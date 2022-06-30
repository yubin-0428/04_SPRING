package com.pcwk.ctrl.member.dao;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.member";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
			
	public MemberDaoImpl() {}
	
	@Override
	public int doMemberInsert(MemberVO inVO) throws SQLException {
		int flag = 0;
		
		String statement = NAMESPACE+".doMemberInsert";
		
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");
		
		flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("flag:"+flag);
		
		return flag;
	}

}
