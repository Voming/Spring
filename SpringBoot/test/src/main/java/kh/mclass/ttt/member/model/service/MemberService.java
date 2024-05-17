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
	
	//@Transactional
	public List<MemberRes> selectList(){
		
		memberDao.insert();
		memberDao.update();
		
		return memberDao.selectList();
	}
	public MemberRes selectOne(String memId){
		return memberDao.selectOne(memId);
	}
}
