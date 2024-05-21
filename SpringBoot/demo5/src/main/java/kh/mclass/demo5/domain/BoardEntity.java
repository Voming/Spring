package kh.mclass.demo5.domain;

import org.springframework.stereotype.Component;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data //tostring, getter/setter
//@Component //따로 추가해줘야됨
//@NoArgsConstructor //기본 생성자
@AllArgsConstructor //기본생성자 못쓰고 전체랑 써야함
//@RequiredArgsConstructor //lombock 사용 @NonNull 필수로 사용해야함
public class BoardEntity {
	//@NonNull 
	private String boardId;
	
	private String boardTitle;
	private String boardContent;
}
