package kh.mclass.demo4.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.mclass.demo4.board.model.service.BoardService;

@Controller
@RequestMapping("/board") //board까지만 치면 boardAll이 보임
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("")
	public String list(Model md) {
		md.addAttribute("boardlist", boardService.selectAllList());
		return "aaa";
	}
	
	@DeleteMapping("/{boardId}")
	public String boardDelete(@PathVariable String boardId) {
		
		return "aaa";
	}

}
