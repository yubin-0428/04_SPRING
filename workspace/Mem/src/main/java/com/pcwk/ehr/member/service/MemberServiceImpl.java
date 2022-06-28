package com.pcwk.ehr.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.member.dao.MemberDao;
import com.pcwk.ehr.member.domain.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVO> memberList(){
		return memberDao.memberList();
	}
	
}
