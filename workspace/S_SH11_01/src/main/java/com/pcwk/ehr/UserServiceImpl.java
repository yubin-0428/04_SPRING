package com.pcwk.ehr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionSynchronization;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class UserServiceImpl implements UserService {

	final Logger LOG = LogManager.getLogger(getClass());
	// 상수 도입 : 30, 50
	// BASIC에서 SILVER로 가는 최소 로그인 수 
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	
	// SILVER에서 GOLD로 가는 최소 로그인 수 
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;
	
	private UserDao userDao;
	
	private DataSource dataSource;
	
	public UserServiceImpl() {}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
		/*		
		        사용자 레벨은 BASIC, SLIVER, GOLD
			사용자가 처음 가입하면 : BASIC
			가입 이후 50회 이상 로그인 하면 : SILVER
			SILVER레벨이면서 30번 이상 추천을 받으면 GOLD로 레벨 UP.
			사용자 레벨의 변경 작업은 일정한 주기를 가지고 일괄처리.(트랜잭션 관리)
		 */
		
		// Spring 트랜잭션 처리
		// 트랜잭션 동기화 관리자를 이용해 동기화 작업을 초기화
		TransactionSynchronizationManager.initSynchronization();
		// DB 커넥션을 생성하고 트랜잭션을 시작한다. 이후 작업은 모두 여기서 시작한 트랜잭션 안에서 진행된다.
		Connection c = DataSourceUtils.getConnection(dataSource);
		c.setAutoCommit(false);
		
		try {
				
			List<UserVO> list = userDao.getAll(inVO);

			for(UserVO user : list) {
				if(canUpgradeLevel(user) == true) {
					upgradeLevel(user);
				}
			}
			
			// 정상적으로 완료되면 트랜잭션 Commit;
			c.commit();
		} catch (Exception e) {
			LOG.debug("======================");
			LOG.debug("=rollback******=");
			LOG.debug("======================");
			
			c.rollback();
			throw e;
		} finally {
			// Spring DataSourceUtils 메서드를 통해 DB 커넥션 닫기
			DataSourceUtils.releaseConnection(c, dataSource);
			
			// 동기화 작업 종료
			TransactionSynchronizationManager.unbindResource(dataSource);
			TransactionSynchronizationManager.clearSynchronization();
		}

	}
	
	/**
	 * 레벨 업그레이드 작업
	 * @param user
	 * @throws SQLException 
	 */
	public void upgradeLevel(UserVO user) throws SQLException {
		
		// 다음 레벨로 UP
		user.upgradeLevel();
		this.userDao.doUpdate(user);
	} 
	
	/**
	 * User가 업그레이드 대상인지 확인
	 * @param user
	 * @return 대상(true) / 대상이 아니면(false)
	 */
	private boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();
		
		switch (currentLevel) {
			case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
			case SILVER: return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
			case GOLD: return false;
			default: throw new IllegalAccessError("Unknown Level : " + currentLevel);
		}
	}

	@Override
	public int add(UserVO inVO) throws SQLException {
		if(null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		
		return userDao.doInsert(inVO);
	}

}
