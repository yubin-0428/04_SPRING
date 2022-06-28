package com.pcwk.ehr.user.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.user.domain.UserVO;

public interface UserDao {

	
	
	/**
	 * 비번확인 check
	 * @param inVO
	 * @return 1(id와 비번 일치)/0(id와 비번 불일치)
	 * @throws SQLException
	 */
	int passCheck(UserVO inVO) throws SQLException;
	
	/**
	 * id중복 check
	 * @param inVO
	 * @return 1(id존재)/0(id없음)
	 * @throws SQLException
	 */
	int idCheck(UserVO inVO) throws SQLException;
	
	
	/**
	 * 목록조회 
	 * @param dto
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	List<UserVO> doRetrieve(DTO dto) throws SQLException;
	
	/**
	 * 사용자 삭제 
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO) throws SQLException;

	/**
	 * 사용자 수정 기능
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO) throws SQLException;
	
	
	List<UserVO> getAll(UserVO inVO);

	int getCount(UserVO inVO) throws SQLException;

	/**
	 * 사용자 등록
	 * 
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws ClassCastException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int doInsert(UserVO inVO) throws SQLException;//수정

	void deleteAll() throws SQLException;

	/**
	 * 회원단건 retruen
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;

}