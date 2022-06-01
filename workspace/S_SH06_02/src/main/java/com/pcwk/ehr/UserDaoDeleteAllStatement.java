package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDaoDeleteAllStatement implements StatementStrategy {
   
   final Logger LOG = LogManager.getLogger(this.getClass());
   @Override
   public PreparedStatement makeStatement(Connection connection) throws SQLException {
      
      PreparedStatement pstmt = null;
      
      StringBuilder sb = new StringBuilder(100);
      sb.append(" DELETE FROM hr_member    \n");
      LOG.debug("============================"); 
      LOG.debug("sql : \n"+sb.toString()); 
      LOG.debug("============================");
      
      //3. 
      pstmt = connection.prepareStatement(sb.toString());
      
      return pstmt;
   }

}