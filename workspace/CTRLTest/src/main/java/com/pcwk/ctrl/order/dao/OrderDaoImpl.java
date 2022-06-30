package com.pcwk.ctrl.order.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	
	final Logger LOG = LogManager.getLogger(this.getClass());

	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.order";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Map<String, DTO>> doRetrieve(MemberVO memberVO) throws SQLException {
		List<Map<String, DTO>> outVO = null;
		
		String statement = this.NAMESPACE+".doRetrieve";
		LOG.debug("=============================");
		LOG.debug("param : " + memberVO.toString());
		LOG.debug("statement : " + statement);
		LOG.debug("=============================");
		
		outVO = this.sqlSessionTemplate.selectList(statement,memberVO);
		
		return outVO;
	}

}
