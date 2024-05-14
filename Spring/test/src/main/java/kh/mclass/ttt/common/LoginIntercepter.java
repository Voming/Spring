package kh.mclass.ttt.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginIntercepter implements HandlerInterceptor {
	// preHandle(): 실제 controller(hadler)가 실행되기 전에 실행되며 boolean타입의 값을 리턴한다
	// true 이면 요청한 handler를 처리하고 false면 처리하지 않는다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		
		System.out.println("인터셉터");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("sslogin");
		//로그인이 되어있지 않은상태	
		if(obj == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}else {
			return true;
		}
	}
}
