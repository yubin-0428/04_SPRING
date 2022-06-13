package com.pcwk.ehr;

import java.sql.SQLException;

public interface UserService {

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
