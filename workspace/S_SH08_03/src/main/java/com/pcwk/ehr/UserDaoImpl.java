package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl implements UserDao {
   final Logger LOG = LogManager.getLogger(this.getClass());

   private DataSource dataSource;
   
   // spring이 제공하는 JdbcTemplate
   private JdbcTemplate jdbcTemplate;
   
   public UserDaoImpl() {}
      
   // setter를 통한 의존성 주입
public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      // 수동으로 생성
      jdbcTemplate = new JdbcTemplate(dataSource);
   }

   @Override
public List<UserVO> getAll(){
	   List<UserVO> list = null;
	   StringBuilder sb = new StringBuilder(150);
	   sb.append("SELECT u_id,   \n");
	   sb.append("       name,   \n");
	   sb.append("       passwd, \n");
	   sb.append("       grade   \n");
	   sb.append("FROM hr_member \n");
	   sb.append("ORDER BY u_id  \n");
	   LOG.debug("=================");
	   LOG.debug("sql:\n"+sb.toString());
	   LOG.debug("=================");
	   
	   list = jdbcTemplate.query(sb.toString(),
			   new RowMapper<UserVO>() {
		   
		   @Override
		   public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException{
			   UserVO user = new UserVO();
			   user.setuId(rs.getString("u_id"));
			   user.setName(rs.getString("name"));
			   user.setPasswd(rs.getString("passwd"));
			   return user;
		   }}
			   );
	   
	   for(UserVO vo : list) {
		   LOG.debug("vo:"+vo.toString());
	   }
	   
	   return list;
   }
   
   @Override
public int getCount(UserVO inVO) throws SQLException {
      int count = 0;
      
      StringBuilder sb = new StringBuilder(100);
      sb.append(" SELECT COUNT(*) AS cnt    \n");
      sb.append(" FROM hr_member            \n");
      sb.append(" WHERE u_id LIKE ?  || '%' \n");
      LOG.debug("=============================");
      LOG.debug("param : "+inVO.toString());
      LOG.debug("sql: \n "+sb.toString());
      LOG.debug("=============================");
      Object[] args = {inVO.getuId()};
      LOG.debug("Object param : "+args[0].toString());
      
      count = jdbcTemplate.queryForObject(sb.toString(), args,Integer.class);
      LOG.debug("====================");
      LOG.debug("=count="+count);
      LOG.debug("====================");
      
      return count;
   }
   
  
   
   
   @Override
public void deleteAll() throws SQLException {
	   StringBuilder sb = new StringBuilder(100);
	      sb.append(" DELETE FROM hr_member    \n");
	      LOG.debug("============================"); 
	      LOG.debug("sql : \n"+sb.toString()); 
	      LOG.debug("============================");
	      
	      // 트랙잭션이 필요한 경우 사용(CUD)
	      jdbcTemplate.update(sb.toString());
	   
	   

	}
	   
   
   /**
    * 회원 단건 return
    * 
    * @param inVO
    * @return UserVO
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   @Override
@SuppressWarnings("deprecation")
public UserVO get(UserVO inVO) throws SQLException{
      UserVO outVO = null;
      StringBuilder sb = new StringBuilder(100);
      sb.append(" SELECT u_id,   \n");
      sb.append("        name,   \n");
      sb.append("        passwd  \n");
      sb.append(" FROM hr_member \n");
      sb.append(" WHERE u_id = ? \n");
      LOG.debug("=============================");
      LOG.debug("param : "+inVO.toString());
      LOG.debug("sql: \n "+sb.toString());
      LOG.debug("=============================");

      Object[] args = {inVO.getuId()};
      LOG.debug("Object param : "+args[0].toString());

      outVO = jdbcTemplate.queryForObject(sb.toString(), 
    		  args,
    		  new RowMapper<UserVO>() {

				@Override
				public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
					UserVO user = new UserVO();
					
					user.setuId(rs.getString("u_id"));
					user.setName(rs.getString("name"));
					user.setPasswd(rs.getString("passwd"));
					
					return user;
				}
    	  
      });
      
      // 데이터가 없으면 예외 발생
      if(null == outVO) {
      throw new NullPointerException();   
      }
      
      LOG.debug("=============================");
      LOG.debug("=outVO="+outVO.toString());
      LOG.debug("=============================");
      
      return outVO;
   }

   /**
    * 사용자 등록
    * 
    * @param inVO
    * @return 1(성공)/0(실패)
    * @throws ClassCastException
    * @throws SQLException
    * @throws ClassNotFoundException
    */
   @Override
public int add(final UserVO inVO) throws SQLException{
      int flag = 0;
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
	    LOG.debug("param : "+ inVO.toString());
	    LOG.debug("sql : \n"+ sb.toString());
	    LOG.debug("============================");
	    
	    Object[] args = {inVO.getuId(), inVO.getName(), inVO.getPasswd()};
	    for(Object obj:args) {
	    	LOG.debug("Object param:"+obj.toString());
	    }
	    
      flag = jdbcTemplate.update(sb.toString(), args);
      LOG.debug("flag:"+flag);
      
      return flag;
   }
}