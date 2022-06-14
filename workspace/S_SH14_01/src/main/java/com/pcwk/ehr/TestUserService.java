package com.pcwk.ehr;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserServiceImpl;

public class TestUserService extends UserServiceImpl {

	final Logger LOG = LogManager.getLogger(getClass());
	
	//사용자 ID
	private String uId;
	
	public TestUserService() {}
	
	public TestUserService(String uId) {
		super();
		this.uId = uId;
		LOG.debug("==========================");
		LOG.debug("=this.uId="+this.uId);
		LOG.debug("==========================");
	}

	/**
	 * 5명의 사용자						
	     등업 대상자는 2번째, 4번쨰 있음						
	   4번째에서 강재로 예외 발생!
	 */
	@Override
	public void upgradeLevel(UserVO user) throws SQLException,TestUserServiceException {
		
		if(this.uId.equals(user.getuId())) {
			LOG.debug("==========================");
			LOG.debug("=upgradeLevel=");
			LOG.debug("==========================");
			
			throw new TestUserServiceException("TestUserServiceException:"+uId);
		}
		super.upgradeLevel(user);
	}
}
