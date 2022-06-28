package com.pcwk.ehr.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.member.domain.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	
	// mybatis namespace
	final String NAMESPACE="com.pcwk.ehr.member";
	
	// mybatis db 연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MemberVO> memberList(){
		return sqlSessionTemplate.selectList("member.member");
	}
	
		
	}
