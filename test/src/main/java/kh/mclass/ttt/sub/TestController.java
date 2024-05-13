package kh.mclass.ttt.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.mclass.ttt.sub.model.dto.TestDto;

@Controller
public class TestController {
	@Autowired
	private TestService testService ;
	@Autowired  //bean을 연결해서 찾아줌 해당 자료형의 bean을 끌어옴
	private TestDto testDto;
	
	
	
//	private TestService service = new TestService(); 
//	private TestService service; //아래처럼하지 않고 간단히
//	@RequestMapping(method = RequestMethod.GET, path = "/test")  //방식은 여러가지가 있음
	//이제부터 RestApi가 동작을 함
	//delete,put,patch를 적절히 사용하기
	@GetMapping("/test") //위에 있는게너무 길어서 나오게 됨
//	@PostMapping
	public String method1(
			@RequestParam(defaultValue = "aaa", required = false, name = "a") String abc, 
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession ss) {
		System.out.println(abc); //아래와 같은 방식을 사용하지 않아도 됨
		System.out.println(request.getParameter("a"));
		
		ss.setAttribute("c", "세션2");
		request.getSession().setAttribute("b", "세션1");
		
		
		request.setAttribute("serverTime", testService.method1());
		
		System.out.println("Dto bean 확인하기");
		System.out.println(testDto);
		return "home";
	}
}
