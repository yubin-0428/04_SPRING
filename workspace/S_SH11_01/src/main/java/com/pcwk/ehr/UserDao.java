package com.pcwk.ehr;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface UserDao {

	/**
	 * 목록 조회
	 * @return List<UserVO>
	 * @throws SQLException
	 */
	List<UserVO> doRetrieve() throws SQLException;
	/**
	 * 사용자 삭제
	 * @param inVO
	 * @return 1(성공) / 0(실패)
	 * @throws SQLException
	 */
	int doDelete(UserVO inVO) throws SQLException;
	
	/**
	 * 사용자 수정 기능
	 * @param inVO
	 * @return 1(성공) / 0(실패)
	 * @throws SQLException
	 */
	int doUpdate(UserVO inVO) throws SQLException;
	
	List<UserVO> getAll(UserVO inVO);

	int getCount(UserVO inVO) throws SQLException;

	void deleteAll() throws SQLException;

	/**
	 * 회원 단건 
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;

	/**
	 * 사용자 등록
	 * 
	 * @param inVO
	 * @return 1(성공)/0(실패)
	 * @throws ClassCastException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	int doInsert(UserVO inVO) throws SQLException; //수정

}