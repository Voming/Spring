package kh.mclass.ttt.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.mclass.ttt.member.model.dto.MemberRes;

@Repository("memberDao")
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;

	public List<MemberRes> selectList() {
		return sqlSession.selectList("Member.list");
	}
	
	public MemberRes selectOne(String memId) {
		return sqlSession.selectOne("Member.one", memId);
	}

	public int insert() {
//		return sqlSession.insert("Member.insert");
		return 0;
	}

	public int update() {
//		return sqlSession.update("Member.update");
		return 0;
	}
	
	public void insertAbc() {
		
	}

}
