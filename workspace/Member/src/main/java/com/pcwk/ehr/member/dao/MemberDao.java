package com.pcwk.ehr.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.member.domain.MemberVO;
import com.pcwk.ehr.member.domain.MemberVO;

public interface MemberDao{
	
	/**
	 * 목록 조회
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	List<MemberVO> doRetrieve(DTO dto) throws SQLException;
	
}

