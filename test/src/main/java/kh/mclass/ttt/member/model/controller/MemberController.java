package kh.mclass.ttt.member.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kh.mclass.ttt.member.model.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/list")
	public String selectList(
			Model model
			) {
		model.addAttribute("memberlist", memberService.selectList());
		return "member/list";
	}
	@GetMapping("/member/one")
	public String selectList(
			Model model
			, String memId
			) {
		model.addAttribute("member", memberService.selectOne(memId));
		return "member/one";
	}
}
