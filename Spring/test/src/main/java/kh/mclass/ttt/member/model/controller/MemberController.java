package kh.mclass.ttt.member.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.mclass.ttt.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public void selectList( //컨트롤러가 리턴을 안하면 url과 같은 jsp를 리턴한다
			Model model
			) {
		model.addAttribute("memberlist", memberService.selectList());
//		return "member/list";
	}
	@GetMapping("/one")
	public String selectList(
			Model model
			, String memId
			) {
		model.addAttribute("member", memberService.selectOne(memId));
		return "member/one";
	}
	
	@PostMapping("/insert")
	public String insert(
			Model model
			, String memId
			) {
		//model.addAttribute("member", memberService.selectOne(memId));
		return "redirect:login"; //페이지가 바뀔때 redirect:로 함
	}
	
	@RequestMapping("/ajax") //get, post 둘다 상관없기 때문에 @RequestMapping/ but get은 거의 사용하지 ㅇ낳음
	//@ResponseBody 위치는 둘다 가능
	public @ResponseBody String getAjax(
			Model model
			, String memId
			) {
		//model.addAttribute("member", memberService.selectOne(memId));
		return "성공했습니다. dtolist or GSON으로 빌린 값"; //페이지가 바뀔때 redirect:로 함
	}
}
