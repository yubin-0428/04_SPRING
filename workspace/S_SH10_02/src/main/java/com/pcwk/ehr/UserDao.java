package com.pcwk.ehr;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public interface UserDao {
	
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
	
	// setter를 통한 의존성 주입
	void setDataSource(DataSource dataSource);
	
	List<UserVO> getAll(UserVO inVO);//수정

	int getCount(UserVO inVO) throws SQLException;

	void deleteAll() throws SQLException;

	/**
	 * 회원단건 return
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	UserVO doSelectOne(UserVO inVO) throws SQLException;//수정

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
	

	int doDeleteAll(UserVO inVO) throws SQLException;

	int doUpdate(UserVO inVO) throws SQLException;

}