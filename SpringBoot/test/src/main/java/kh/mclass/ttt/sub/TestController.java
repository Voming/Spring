package kh.mclass.ttt.sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	//private TestService service = new TestService();
		@Autowired
		private TestService testService;
		
		@GetMapping("/login")
		public String login(
				Model model
				, String memId
				) {
			//model.addAttribute("memberlist", memberService.selectList());
			return "home";
		}
		
		//@RequestMapping(method = RequestMethod.GET, path = "/testget")
		@GetMapping("/test")
		public String method1(
				@RequestParam(defaultValue = "aaa", required = false, name = "a") String b,
				HttpServletRequest request,  
				HttpSession ss,
				HttpServletResponse res
				) {
			
			
			System.out.println(b);
			System.out.println(request.getParameter("a"));
			request.getSession().setAttribute("b", "세션값");
			ss.setAttribute("c", "세션2");
			
			request.setAttribute("serverTime", testService.method1());
			return "home";
		}
		@GetMapping("/test/one")
		public String method2(
				@RequestParam(defaultValue = "aaa", required = false, name = "a") String b,
				HttpServletRequest request,  
				HttpSession ss,
				HttpServletResponse res
				) {
			System.out.println(b);
			System.out.println(request.getParameter("a"));
			request.getSession().setAttribute("b", "세션값");
			ss.setAttribute("c", "세션2");
			
			request.setAttribute("serverTime", testService.method1());
			return "home";
		}
	
	
	
	
	
//	@Autowired
//	private TestService testService ;
//	@Autowired  //bean을 연결해서 찾아줌 해당 자료형의 bean을 끌어옴
////	@Qualifier(value = "testDto")
//	private TestDto testDto; //이걸 여러개 선언해뒀을 경우 객체 이름을 주의해야함
//	@Autowired 
////	@Qualifier(value = "testDto2") //이전에는 잘 인식하지 못했기떄문에 사용함
//	private TestDto testDto2;
//	@Autowired 
//	private TestDto testDto3;
//	
////	private TestService service = new TestService(); 
////	private TestService service; //아래처럼하지 않고 간단히
////	@RequestMapping(method = RequestMethod.GET, path = "/test")  //방식은 여러가지가 있음
//	//이제부터 RestApi가 동작을 함
//	//delete,put,patch를 적절히 사용하기
//	@GetMapping("/test") //위에 있는게너무 길어서 나오게 됨
////	@PostMapping
//	public String method1(
//			@RequestParam(defaultValue = "aaa", required = false, name = "a") String abc, 
//			HttpServletRequest request, 
//			HttpServletResponse response,
//			HttpSession ss) {
//		System.out.println(abc); //아래와 같은 방식을 사용하지 않아도 됨
//		System.out.println(request.getParameter("a"));
//		
//		ss.setAttribute("c", "세션2");
//		request.getSession().setAttribute("b", "세션1");
//		
//		
//		request.setAttribute("serverTime", testService.method1());
//		
//		System.out.println("Dto bean 확인하기");
//		System.out.println(testDto);
//		System.out.println(testDto2);
//		System.out.println(testDto3);
//		return "home";
//	}
}
