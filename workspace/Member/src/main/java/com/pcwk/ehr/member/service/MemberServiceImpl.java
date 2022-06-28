package com.pcwk.ehr.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.member.dao.MemberDao;
import com.pcwk.ehr.member.domain.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<MemberVO> doRetrieve(DTO dto) throws SQLException {
		return memberDao.doRetrieve(dto);
	}

}
