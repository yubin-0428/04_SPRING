package com.pcwk.ehr;

import java.sql.SQLException;

public interface UserService {

	/**
	 * 등업기능
	 * @throws SQLException
	 */
	public void upgradeLevels() throws SQLException;
	
	
}
