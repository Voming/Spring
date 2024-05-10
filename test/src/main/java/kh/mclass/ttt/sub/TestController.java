package kh.mclass.ttt.sub;

import java.security.Provider.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@Autowired
	private TestService service ;
//	private TestService service = new TestService(); 
//	private TestService service; //아래처럼하지 않고 간단히
//	@RequestMapping(method = RequestMethod.GET, path = "/test")  //방식은 여러가지가 있음
	//이제부터 RestApi가 동작을 함
	//delete,put,patch를 적절히 사용하기
	@GetMapping("/test") //위에 있는게너무 길어서 나오게 됨
//	@PostMapping
	public String method1(String a, 
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession ss) {
		System.out.println(a); //아래와 같은 방식을 사용하지 않아도 됨
		System.out.println(request.getParameter("a"));
		
		ss.setAttribute("c", "세션2");
		request.getSession().setAttribute("b", "세션1");
		
		
		request.setAttribute("serverTime", service.method1());
		return "home";
	}
}
