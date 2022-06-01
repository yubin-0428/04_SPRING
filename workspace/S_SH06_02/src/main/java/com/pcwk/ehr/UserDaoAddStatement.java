package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoAddStatement implements StatementStrategy {
	
	final Logger LOG = LogManager.getLogger(this.getClass());
	UserVO user;
	
	public UserDaoAddStatement() {}
	public UserDaoAddStatement(UserVO user) {
		this.user = user;
	}
	
	@Override
	public PreparedStatement makeStatement(Connection connection) throws SQLException {
		
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder(100);
	    sb.append(" INSERT INTO hr_member ( \n");
	    sb.append("        u_id,           \n");
	    sb.append("        name,           \n");
	    sb.append("        passwd          \n");
	    sb.append("    ) VALUES (          \n");
	    sb.append("        ?,              \n");
	    sb.append("        ?,              \n");
	    sb.append("        ?               \n");
	    sb.append("    )                   \n");
	    LOG.debug("============================");
	    LOG.debug("param : "+ user.toString());
	    LOG.debug("sql : \n"+ sb.toString());
	    LOG.debug("============================");
		
	    pstmt = connection.prepareStatement(sb.toString());
	    pstmt.setString(1, user.getuId());
	    pstmt.setString(2, user.getName());
	    pstmt.setString(3, user.getPasswd());
	    
		return pstmt;
	}

}
