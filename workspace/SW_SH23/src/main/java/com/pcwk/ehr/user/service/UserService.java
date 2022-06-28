package com.pcwk.ehr.user.service;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.user.domain.UserVO;

public interface UserService {

	
	/**
	 * 아이디 비번확인
	 * @param inVO
	 * @return MessageVO
	 * @throws SQLException
	 */	
	public MessageVO  idPassCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 비번확인 check
	 * @param inVO
	 * @return 1(id와 비번 일치)/0(id와 비번 불일치)
	 * @throws SQLException
	 */
	public int passCheck(UserVO inVO) throws SQLException;
	
	/**
	 * id중복 check
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int idCheck(UserVO inVO) throws SQLException;
	
	/**
	 * 회원목록 조회
	 * @param dto
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	public List<UserVO> doRetrieve(DTO dto) throws SQLException;
	
	/**
	 * 회원정보 삭제
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doDelete(UserVO inVO) throws SQLException;
	/**
	 * 회원정보 단건 조회
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 */
	public UserVO doSelectOne(UserVO inVO) throws SQLException;
	
	/**
	 * 회원정보 수정
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doUpdate(UserVO inVO) throws SQLException;
	
	/**
	 * 회원등록
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int doInsert(final UserVO inVO) throws SQLException;
	
	
	
	/**
	 * 등업기능
	 * @throws SQLException
	 */
	public void upgradeLevels(UserVO inVO) throws SQLException;
	
	
	// 
	
	/**
	 * 최초 가입자는 기본적으로 BASIC 레벨이어야 한다.
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	public int add(UserVO inVO) throws SQLException;
	
	
}
