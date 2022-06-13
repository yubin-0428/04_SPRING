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

	//spring 제공하는 JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	
	//RowMapper
	RowMapper<UserVO> rowMapper = new RowMapper<UserVO>() {

			@Override
			public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserVO user=new UserVO();
				user.setuId(rs.getString("u_id"));
	            user.setName(rs.getString("name"));
	            user.setPasswd( rs.getString("passwd"));
	            
	            //1 - > BASIC
	            user.setLevel(Level.valueOf(rs.getInt("u_level")));   ;
	            user.setLogin(rs.getInt("login"));
	            user.setRecommend(rs.getInt("recommend"));
	            user.setEmail(rs.getString("email"));;
	            user.setRegDt(rs.getString("reg_dt"));
	            
				return user;
			}

	};
	
	public UserDaoImpl() {}


	// setter를 통한 의존성 주입
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		//수동으로 생성
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		int flag = 0;
		StringBuilder sb=new StringBuilder(200);
		sb.append(" UPDATE hr_member         \n");
		sb.append(" SET name      = ?,       \n");
		sb.append("     passwd    = ?,       \n");
		sb.append("     u_level   = ?,       \n");
		sb.append("     login     = ?,       \n");
		sb.append("     recommend = ?,       \n");
		sb.append("     email     = ?,       \n");
		sb.append("     reg_dt    = SYSDATE  \n");
		sb.append(" WHERE u_id = ?           \n");		
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");	
		Object[] args = {inVO.getName(), inVO.getPasswd(),
                inVO.getLevel().getValue(),inVO.getLogin(),inVO.getRecommend()
                ,inVO.getEmail(),inVO.getuId()		
        };		
		
		for(Object obj  :args) {
			LOG.debug("Object param:"+obj.toString());
		}		
		
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag:" + flag);
		return flag;
	}
	
	
	
	
	
	@Override
	public List<UserVO> getAll(UserVO inVO){
		//sb.append(" WHERE u_id LIKE ?	||'%'   \n");
		List<UserVO> list= null;
		StringBuilder sb=new StringBuilder(150);
		sb.append(" SELECT u_id,        \n");
		sb.append("        name,        \n");
		sb.append("        passwd,      \n");
		sb.append("        u_level,     \n");			
		sb.append("        login,	    \n");		
		sb.append("        recommend,	\n");		
		sb.append("        email,		\n");	
		sb.append("        TO_CHAR(reg_dt,'yyyy-mm-dd hh24:mi:ss') AS reg_dt		\n");
		sb.append(" FROM hr_member  \n");
		sb.append(" WHERE u_id LIKE ?	||'%'   \n");		
		sb.append(" ORDER BY u_id   \n");		
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		
		LOG.debug("==============================");	
		Object[] args = {inVO.getuId()};
		
		list = jdbcTemplate.query(sb.toString(),rowMapper,args);
		
		for(UserVO vo  :list) {
			LOG.debug("vo:"+vo.toString());
		}
		
		return list;
	}
	

	@Override
	public int getCount(UserVO inVO) throws SQLException{
		int count = 0;

		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT COUNT(*) AS cnt      \n");
		sb.append(" FROM  hr_member             \n");
		sb.append(" WHERE u_id LIKE ?	||'%'   \n");
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");
		Object[] args = {inVO.getuId()};
		LOG.debug("Object param:" + args[0].toString());
		
		
		count = jdbcTemplate.queryForObject(sb.toString(), args,Integer.class);
		LOG.debug("==============================");
		LOG.debug("count=" + count);
		LOG.debug("==============================");			
	
		return count;
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
	public int doInsert(final UserVO inVO) throws SQLException {
		int flag = 0;
		StringBuilder sb = new StringBuilder(100);
		sb.append(" INSERT INTO hr_member ( \n");
		sb.append("         u_id,           \n");
		sb.append("         name,           \n");
		sb.append("         passwd,         \n");
		sb.append("         u_level,        \n");			
		sb.append("         login,	        \n");		
		sb.append("         recommend,	    \n");		
		sb.append("         email,		    \n");	
		sb.append("         reg_dt		    \n");
		sb.append(" ) VALUES (              \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n"); 
		sb.append("     ?,                  \n");
		sb.append("     ?,                  \n");		
		sb.append("     ?,                  \n");
		sb.append("     SYSDATE             \n");
		sb.append(" )                       \n");
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");	
		Object[] args = {inVO.getuId(), inVO.getName(), inVO.getPasswd(),
		                 inVO.getLevel().getValue(),inVO.getLogin(),inVO.getRecommend(),inVO.getEmail()		
		};
		for(Object obj  :args) {
			LOG.debug("Object param:"+obj.toString());
		}
		
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag:" + flag);

		
		return flag;
	}
	
	@Override
	public void deleteAll()throws SQLException{
		StringBuilder sb = new StringBuilder(100);
		sb.append(" DELETE FROM hr_member \n");
		LOG.debug("==============================");
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");
		
		//트랜잭션이 필요한 경우 사용(CUD)
		jdbcTemplate.update(sb.toString());
		
		
	}
	
	/**
	 * 회원단건 retruen
	 * 
	 * @param inVO
	 * @return UserVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Override
	@SuppressWarnings("deprecation")
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		UserVO outVO = null;
		StringBuilder sb = new StringBuilder(100);
		sb.append(" SELECT u_id,        \n");
		sb.append("        name,        \n");
		sb.append("        passwd,      \n");
		sb.append("        u_level,     \n");			
		sb.append("        login,	    \n");		
		sb.append("        recommend,	\n");		
		sb.append("        email,		\n");	
		sb.append("        TO_CHAR(reg_dt,'yyyy-mm-dd hh24:mi:ss') AS reg_dt		\n");
		sb.append(" FROM  hr_member  \n");
		sb.append(" WHERE u_id = ?   \n");
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");
		
		Object[] args = {inVO.getuId()};
		LOG.debug("Object param:" + args[0].toString());
		
		outVO = jdbcTemplate.queryForObject(sb.toString(), args,rowMapper);
		LOG.debug("==============================");
		LOG.debug("outVO=" + outVO.toString());
		LOG.debug("==============================");
		
		
		//데이터가 없으면 예외 발생
//		if(null == outVO) {
//			throw new NullPointerException();
//		}
		
		LOG.debug("==============================");
		LOG.debug("outVO=" + outVO.toString());
		LOG.debug("==============================");


		return outVO;
	}


	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		int flag = 0;
		
		StringBuilder sb=new StringBuilder(50);
		sb.append(" DELETE FROM hr_member         \n");
		sb.append(" WHERE u_id = ?                \n");		
		LOG.debug("==============================");
		LOG.debug("param:" + inVO.toString());
		LOG.debug("sql:\n" + sb.toString());
		LOG.debug("==============================");	
		Object[] args = {inVO.getuId()	};		
		
		for(Object obj  :args) {
			LOG.debug("Object param:"+obj.toString());
		}		
		
		flag = jdbcTemplate.update(sb.toString(), args);
		LOG.debug("flag:" + flag);
		return flag;
	}


	@Override
	public List<UserVO> doRetrieve(DTO dto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}






}
