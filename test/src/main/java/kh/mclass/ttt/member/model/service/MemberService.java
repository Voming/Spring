package kh.mclass.ttt.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.mclass.ttt.member.model.dao.MemberDao;
import kh.mclass.ttt.member.model.dto.MemberRes;

@Service("memberService")
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	public List<MemberRes> selectList(){
		return memberDao.selectList();
	}
}
