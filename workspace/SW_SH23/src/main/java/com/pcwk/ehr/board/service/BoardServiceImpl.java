/**
* <pre>
* com.pcwk.ehr.board.service
* Class Name : BoardServiceImpl.java
* Description: 게시글 서비스
* Author: ITSC
* Since: 2022/06/27
* Version 0.1
* Copyright (C) by KandJang All right
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/06/27 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.board.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ehr.board.dao.BoardDao;
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.cmn.DTO;

/**
 * @author ITSC
 *
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	private BoardDao  boardDao;
	
	
	public BoardServiceImpl() {
		
	}
	
	
	@Override
	public List<BoardVO> doRetrieve(DTO dto) throws SQLException {
		return boardDao.doRetrieve(dto);
	}

	@Override
	public int doDelete(BoardVO inVO) throws SQLException {
		return boardDao.doDelete(inVO);
	}

	@Override
	public int doUpdate(BoardVO inVO) throws SQLException {
		return boardDao.doUpdate(inVO);
	}

	@Override
	public int doInsert(BoardVO inVO) throws SQLException {
		return boardDao.doInsert(inVO);
	}

	@Override
	public BoardVO doSelectOne(BoardVO inVO) throws SQLException {
        //1.단건 조회
		//2.조회count증가 
		BoardVO outVO = boardDao.doSelectOne(inVO);
		//2.1. 본인이 등록한 글은 조회count가 증가되지 않게 처리
		
		//if(null != outVO && !outVO.getRegId().equals(inVO.getModId())) {
		if(null != outVO ) {
			boardDao.updateReadCnt(inVO);
		}
		
		return outVO;
	}

}






