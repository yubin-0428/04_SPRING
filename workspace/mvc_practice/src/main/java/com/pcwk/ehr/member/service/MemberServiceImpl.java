package com.pcwk.ehr.member.service;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.member.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private MemberDao memberDao;
	
}
