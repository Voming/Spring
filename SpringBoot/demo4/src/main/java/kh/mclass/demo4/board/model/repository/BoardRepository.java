package kh.mclass.demo4.board.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kh.mclass.demo4.board.domain.BoardEntity;

@Mapper
public interface BoardRepository {
	//매퍼의 아이디 명이 메소드 명
	//namespace가 현재 클래스의 위치
	//인터페이스 자체가 객체 생성도 가능하게 함
	//클래스 명을 BoardMapper라고 쓰기도 함
	//여기는 추상화 되어있고 board-mapper에 진짜 정의 되어있음
	public List<BoardEntity> selectAllList(); 

}




//@Repository -> 사용하지 않을 예정
//public interface BoardRepository {
//	@Autowired
//	private SqlSession session;
//	
//	public List<BoardEntity> selectAll(){
//		return session.selectList("namespace.id");
//	}
//}
