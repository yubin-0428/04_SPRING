package com.pcwk.ehr.member.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	// mybatis namespace
	final String NAMESPACE="com.pcwk.ehr.member";
	
	// mybatis db 연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	
		
	}
