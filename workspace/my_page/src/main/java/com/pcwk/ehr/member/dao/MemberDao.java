package com.pcwk.ehr.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.MemberVO;

public interface MemberDao{
	
	/**
	 * 목록 조회
	 * @param dto
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	public List<MemberVO> memberList();

}