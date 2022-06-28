package com.pcwk.ehr.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.cmn.MemberVO;
import com.pcwk.ehr.member.dao.MemberDaoImpl;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDaoImpl memberDao;
	
	@Override
	public List<MemberVO> memberList(){
		return memberDao.memberList();
	}
	
}
