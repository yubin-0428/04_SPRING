package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	
	/**
	 * 약한 결합을 위한 interface도입
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public Connection makeConnection() throws ClassNotFoundException,SQLException;
}
