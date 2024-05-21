package kh.mclass.demo5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kh.mclass.demo5.domain.BoardEntity;

@Controller
public class DemoController {
	@GetMapping("common/header")
	public void commonheader() {
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}

	@GetMapping("board/list")
	public void boardlist(Model model, HttpSession session) {
		// DB연동
		List<BoardEntity> boardlist = new ArrayList<>();
		for(int i =0; i<10; i++) {
			BoardEntity dto = new BoardEntity(i+"", i+ "제목입니다", i+ "내용입니다");
			boardlist.add(dto);
		}
		model.addAttribute("boardlist", boardlist); // thymeleaf로 전달
//		BoardEntity sessionDto = new BoardEntity("00", "00session제목입니다", "00session내용입니다");
//		session.setAttribute("demosession", sessionDto);
		// return "home";
	}

	@GetMapping("board/{boardId}")
	public String boardRead(Model model, @PathVariable String boardId) {
		// DB연동
		System.out.println("/board/" + boardId);
		BoardEntity dto = new BoardEntity(boardId, boardId + "제목입니다", boardId + "내용입니다");
		model.addAttribute("board", dto); // thymeleaf로 전달
		return "board/read";
	}

	@GetMapping("board/list/ajax")
	@ResponseBody
	public BoardEntity boardlistajax(Model model) {
		BoardEntity dto = new BoardEntity("12", "제목입니다", "내용입니다");
		return dto; // tojson 안써도 Json형태로 return됨
	}

}
