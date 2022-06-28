package com.pcwk.ehr.member.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.member.domain.MemberVO;

public interface MemberService {
	
	/**
	 * 회원목록 조회
	 * @param dto
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	public List<MemberVO> doRetrieve(DTO dto) throws SQLException;
	
	
}
