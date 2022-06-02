package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {

	private DataSource dataSource;
	
	public JdbcContext() {}
	// dataSource를 DI 하기위한 setter생성
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int workWithStatementStratege(StatementStrategy stmt) throws SQLException {
	      int flag = 0;
	      // 1.
	      Connection connection = null;
	      PreparedStatement pstmt = null;
	      
	      try {
	         connection = dataSource.getConnection();
	         pstmt = stmt.makeStatement(connection);
	         flag = pstmt.executeUpdate();
	      }catch(SQLException e) {
	         throw e;
	      }finally {
	         if(null != pstmt) {
	            try {
	               pstmt.close();
	            }catch(SQLException e) {
	               
	            }
	         }
	         // connection 자원반납
	         if(null != connection ) {
	            try {
	               connection.close();
	            }catch(SQLException e) {
	               
	            }
	         }
	         
	      }
	      
	      return flag;
	   }
	   
}
