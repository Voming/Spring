package kh.mclass.demo4.board.domain;

import org.springframework.stereotype.Component;

import lombok.Data;
//import lombok.ToString;

@Data //getter,setter,component,tostring
//@ToString
@Component
public class BoardEntity {
	private String boardId;
	private String subject;
	private String writeTime; 
	private String boardWriter;
	private Integer readCount;
}
