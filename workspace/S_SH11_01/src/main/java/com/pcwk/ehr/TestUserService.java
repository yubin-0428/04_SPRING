package com.pcwk.ehr;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUserService extends UserServiceImpl {

	final Logger LOG = LogManager.getLogger(getClass());
	
	// 사용자 ID
	private String uId;
	
	public TestUserService() {}
	
	public TestUserService(String uId) {
		super();
		this.uId = uId;
		LOG.debug("=======================");
		LOG.debug("=this.uId=" + this.uId);
		LOG.debug("=======================");
	}
	
	@Override
	public void upgradeLevel(UserVO user) throws SQLException, TestUserServiceException {
		if(this.uId.equals(user.getuId())) {
			LOG.debug("=======================");
			LOG.debug("=upgradeLevels=");
			LOG.debug("=======================");
			
			throw new TestUserServiceException("TestUserServiceException : " + uId);
		}
		
		super.upgradeLevel(user);
	}
	
}
