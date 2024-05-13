package kh.mclass.ttt.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.mclass.ttt.member.model.dao.MemberDao;
import kh.mclass.ttt.member.model.dto.MemberRes;

@Service("memberService")
@Transactional //트랜잭션 처리 자동화
public class MemberService {
	@Autowired
	private MemberDao memberDao;

	public List<MemberRes> selectList() {
		return memberDao.selectList();
	}

//	@Transactional
	public int insertUpdate() {
		//알아서 필요한 경우에 rollback을 해줌(오류가 발생한 경우/ 0이리턴된것과는 다름)
		//각각 걸면 트랜잭션을 사용하는 이유가 없음
		//일처리 묶음 단위는 서비스에 줄것을 명시할 수 있음
		memberDao.insert();
		memberDao.update(); 

		return 0;
	}
	
//	@Transactional
	public void insertAbc() {
		
	}
}
