/**
* <pre>
* com.pcwk.ehr.board.dao
* Class Name : BoardDaoImpl.java
* Description:
* Author: ITSC
* Since: 2022/06/24
* Version 0.1
* Copyright (C) by KandJang All right
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/06/24 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.user.domain.UserVO;

/**
 * @author ITSC
 *
 */
@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	//mybatis namespace
	final String NAVESPACE ="com.pcwk.ehr.board";
	
	//mybatis db연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public BoardDaoImpl() {}
	
	@Override
	public List<BoardVO> doRetrieve(DTO dto) throws SQLException {
        List<BoardVO> list =new ArrayList<BoardVO>();
        String statement = NAVESPACE+".doRetrieve";
        SearchVO   inVO = (SearchVO) dto;
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");        
		
		list = sqlSessionTemplate.selectList(statement, inVO);
        
		for(BoardVO vo :list) {
			LOG.debug(vo);
		}
		
		return list;
	}

	@Override
	public int doDelete(BoardVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAVESPACE+".doDelete";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");		
		
		flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("flag:" + flag);
		return flag;
	}

	@Override
	public int doUpdate(BoardVO inVO) throws SQLException {
        int flag = 0;
		String statement = NAVESPACE+".doUpdate";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");	        
        
		flag = sqlSessionTemplate.update(statement, inVO);
		LOG.debug("flag:" + flag);
        
		return flag;
	}

	@Override
	public int getCount(BoardVO inVO) throws SQLException {
		int count = 0;
		String statement = NAVESPACE+".getCount";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");			
		count = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("count:" + count);
		return count;
	}

	@Override
	public int doInsert(BoardVO inVO) throws SQLException {
        int flag = 0;
        String statement = NAVESPACE+".doInsert";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");	
		
		flag = sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("flag:" + flag);
		return flag;
	}

	@Override
	public BoardVO doSelectOne(BoardVO inVO) throws SQLException {
		BoardVO outVO = null;
		String statement = NAVESPACE+".doSelectOne";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");			
		
		outVO = sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("outVO:" + outVO);
		return outVO;
	}

	@Override
	public int updateReadCnt(BoardVO inVO) throws SQLException {
		int flag = 0;
		String statement = NAVESPACE+".updateReadCnt";
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("statement:" + statement);
		LOG.debug("==============================");			
		flag = sqlSessionTemplate.update(statement, inVO);
		
		LOG.debug("flag:" + flag);
		return flag;
	}


}















