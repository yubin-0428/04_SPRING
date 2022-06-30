package com.pcwk.ctrl.my_page.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.MemberVO;

public interface My_pageDao {

	/**
	 * 목록 조회
	 * @param dto
	 * @return List<MemberVO>
	 * @throws SQLException
	 */
	public List<MemberVO> memberList();
}
