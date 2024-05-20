package kh.mclass.demo4.board.controller;

import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kh.mclass.demo4.board.domain.BoardEntity;
import kh.mclass.demo4.board.model.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController2 {

	@Autowired
	private BoardService boardService;
	
	@GetMapping
	public List<BoardEntity> list(){
		List<BoardEntity> boardlist = boardService.selectAllList();
		return boardlist;  //기본적으로 json 포멧으로 넘어감
	}
	
	@GetMapping("/{boardId}")
	public ResponseEntity<List<BoardEntity>> delete(@PathVariable String a){
		List<BoardEntity> boardlist = boardService.selectAllList();
		
		//return ResponseEntity.internalServerError().build(); //500번 오류가 넘어감
		//return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(boardlist);
	}
	
}
