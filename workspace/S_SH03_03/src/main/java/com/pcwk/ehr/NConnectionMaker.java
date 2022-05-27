package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NConnectionMaker implements ConnectionMaker {
	final Logger LOG = LogManager.getLogger(this.getClass());
	   
	   final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	   final String DB_URL = "jdbc:oracle:thin:@192.168.3.101:1521:xe";
	   final String USER_ID = "SPRING";
	   final String USER_PASS = "pcwk_spring";
	   
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);

	      Connection connection = DriverManager.getConnection(DB_URL, USER_ID, USER_PASS);
	      LOG.debug("========================");
	      LOG.debug("=connection=" + connection);
	      LOG.debug("========================");

	      return connection;
		
	}

}
