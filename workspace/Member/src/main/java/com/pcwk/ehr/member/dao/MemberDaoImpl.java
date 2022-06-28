package com.pcwk.ehr.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.member.domain.MemberVO;
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
	public List<MemberVO> doRetrieve(DTO dto) throws SQLException {
		SearchVO inVO = (SearchVO) dto;
		String statement = NAMESPACE+".doRetrieve";
		LOG.debug("=============================");
		LOG.debug("param :" + dto.toString());
		LOG.debug("statement" + statement);
		LOG.debug("=============================");
		
		List<MemberVO> list = sqlSessionTemplate.selectList(statement,inVO);
		
		for(MemberVO vo : list) {
			LOG.debug(vo);
		}
		return list;
	}
	
	
		
	}
