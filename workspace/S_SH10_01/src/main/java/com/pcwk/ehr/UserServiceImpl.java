package com.pcwk.ehr;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	private UserDao userDao;
	
	public UserServiceImpl() {}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {
	/*
             사용자 레벨은 : BASIC, SILVER, GOLD
             사용자 처음 가입 화면 : BASIC
             가입 이후 50회 이상 로그인 하면 : SILVER
      SILVER레벨이면서 30번이상 추천을 받으면 GOLD로 레벨 UP.
             사용자 레벨의 변경 작업은 일정한 주기를 가지고 일괄 처리(트랜잭션 관리)
    */
		
		List<UserVO> list = userDao.getAll(inVO);
		
		// BASIC(50회 이상 로그인) -> SILVER
		// SILVER(0번 이상 추천) -> GOLD
		// GOLD는 대상이 아님
		
		for(UserVO user : list) {
			boolean changeLevel = false;
			
			if(user.getLevel() == Level.BASIC && user.getLogin() >= 50) {
				changeLevel = true;
				user.setLevel(Level.SILVER);
			}else if(user.getLevel() == Level.SILVER && user.getRecommend() >= 30) {
				changeLevel = true;
				user.setLevel(Level.GOLD);
			}else if(user.getLevel() == Level.GOLD) {
				changeLevel = false;
			}else {
				changeLevel = false;
			}
			
			// 등업대상이면 등업한다.
			if(changeLevel == true) {
				userDao.doUpdate(user);
			}
		}
	}

	@Override
	public int add(UserVO inVO) throws SQLException {
		if(null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}
		return this.userDao.doInsert(inVO);
	}


}






