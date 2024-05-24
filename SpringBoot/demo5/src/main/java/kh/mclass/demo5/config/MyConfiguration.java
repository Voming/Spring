package kh.mclass.demo5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.mclass.demo5.common.LoginInterceptor;

@Configuration
@EnableWebMvc //내부에 Bean이 있을 가능성이 높음
public class MyConfiguration implements WebMvcConfigurer{
//	@Autowired
//	private LoginInterceptor loginInterceptor;
	
	@Bean
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("sslogin");
				// 로그인이 되어있지 않음 상태
				if (obj == null) {
					response.sendRedirect(request.getContextPath() + "/login");
					// 더이상 컨트롤러 요청으로 가지 않도록 false로 반환
					return false;
				} else {
					// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임 따라서 true로하면 컨트롤러 uri로 가게 됨.
					return true;
				}
			}
		
		})
			.addPathPatterns("/**")
			.excludePathPatterns("/login")
			.excludePathPatterns("/join")
			.excludePathPatterns("/main/*")
			.excludePathPatterns("/css/**","/js/**","/image/**");
	}
	
	
	//정적 페이지 Path 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css");
		registry.addResourceHandler("/html/**").addResourceLocations("classpath:/static/html");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js");
		registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image");
	}
	
	@Bean
	public Object mybean() {
		Object retObj = null;
		return retObj;
	}

}
