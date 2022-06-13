package com.pcwk.ehr;

import java.sql.SQLException;

public interface UserService {

	/**
	 * 등업기능
	 * @throws SQLException
	 */

	void upgradeLevels(UserVO inVO) throws SQLException;
	
	/**
	 *  초 가입자는 기본적으로 BASIC 레벨이어야 한다.
	 * @param inVO
	 * @return
	 * @throws SQLException
	 */
	public int add(UserVO inVO) throws SQLException;
}
