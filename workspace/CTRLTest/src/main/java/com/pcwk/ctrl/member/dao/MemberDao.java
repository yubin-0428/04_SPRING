package com.pcwk.ctrl.member.dao;

import java.sql.SQLException;

import com.pcwk.ctrl.cmn.MemberVO;

public interface MemberDao {

	/**
	 * 회원 등록
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doMemberInsert(MemberVO inVO) throws SQLException;
	
}
