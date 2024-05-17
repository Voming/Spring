package kh.mclass.demo4.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board") //board까지만 치면 boardAll이 보임
public class BoardController {
	
	@GetMapping("")
	public String list() {
		
		return "aaa";
	}
	
	@DeleteMapping("/{boardId}")
	public String boardDelete(@PathVariable String boardId) {
		
		return "aaa";
	}

}
