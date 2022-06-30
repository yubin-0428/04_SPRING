package com.pcwk.ctrl.cart.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.CartVO;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	final Logger LOG = LogManager.getLogger(this.getClass());

	//mybatis namespace
	final String NAMESPACE = "com.pcwk.ctrl.cart";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public CartVO doCartSelect(CartVO vo) {
		CartVO outVO = null;
		
		String statement = NAMESPACE+".doCartSelect";
		
		LOG.debug("=============================");
		LOG.debug("param :" + vo.toString());
		LOG.debug("statement :" + statement);
		LOG.debug("=============================");
		
		outVO = this.sqlSessionTemplate.selectOne(statement,vo);
		
		LOG.debug("=============================");
		LOG.debug("outVO="+outVO.toString());
		LOG.debug("=============================");
		
		return outVO;
	}


}