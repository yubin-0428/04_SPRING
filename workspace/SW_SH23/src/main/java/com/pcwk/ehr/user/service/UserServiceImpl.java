package com.pcwk.ehr.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.pcwk.ehr.TestUserServiceException;
import com.pcwk.ehr.cmn.DTO;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;

import org.springframework.transaction.support.TransactionSynchronization;

import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service("userService")
public class UserServiceImpl implements UserService {

	final Logger LOG = LogManager.getLogger(getClass());
	// 상수 도입: 30,50
	// BASIC에서 SILVER로 가는 최소 로그인 수
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;

	// SILVER에서 GOLD로 가는 추천 수
	public static final int MIN_RECOMMEND_FOR_GOLD = 30;

	@Autowired
	private UserDao userDao;


	// mail: MailSender구현 class가 2개가 있으므로 지정필요!
	@Autowired
	@Qualifier("dummyMailSender")
	private MailSender mailSender;

	public UserServiceImpl() {
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void upgradeLevels(UserVO inVO) throws SQLException {

		try {
			List<UserVO> list = userDao.getAll(inVO);

			for (UserVO user : list) {

				if (canUpgradeLevel(user) == true) {
					upgradeLevel(user);
				}
			}
		} catch (TestUserServiceException e) {
			LOG.debug("====================");
			LOG.debug("=TestUserServiceException="+e.getMessage());
			LOG.debug("====================");
			throw e;
		}
	}

	/**
	 * 레벨 업그레이드 작업
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void upgradeLevel(UserVO user) throws SQLException {

		//p31000
//		if("p31000".equals(user.getuId())) {
//			throw new TestUserServiceException("트랜잭션 테스트:"+user.getuId());
//		}
		
		
		// 다음 레벨로 up
		user.upgradeLevel();
		userDao.doUpdate(user);
		// 등업되면 mail전송
		sendupgradeMail(user);
	}

	/**
	 * 등업되면 메일 전송 BASIC -> SILVER:2번째 SILVER -> GOLD:4번째
	 * 
	 * @param user
	 */
	public void sendupgradeMail(UserVO user) {
        SimpleMailMessage  message=new SimpleMailMessage();
        message.setTo(user.getEmail());//받는 사람
        message.setFrom("jamesol@naver.com");
        message.setSubject("등업 안내");
        message.setText("사용자의 등급이 "+user.getLevel().name()+"로 업그레이드 되었습니다.");
        
        mailSender.send(message);
	}

	/**
	 * User가 업그레이드 대상인지 확인
	 * 
	 * @param user
	 * @return 대상(true)/대상이 아니면(false)
	 */
	private boolean canUpgradeLevel(UserVO user) {
		Level currentLevel = user.getLevel();

		switch (currentLevel) {
		case BASIC:
			return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
		case SILVER:
			return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
		case GOLD:
			return false;
		default:
			throw new IllegalAccessError("Unknown Level:" + currentLevel);
		}

	}

	@Override
	public int add(UserVO inVO) throws SQLException {

		if (null == inVO.getLevel()) {
			inVO.setLevel(Level.BASIC);
		}

		return userDao.doInsert(inVO);
	}

	@Override
	public List<UserVO> doRetrieve(DTO dto) throws SQLException {
		return userDao.doRetrieve(dto);
	}

	@Override
	public int doDelete(UserVO inVO) throws SQLException {
		return userDao.doDelete(inVO);
	}

	@Override
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		return userDao.doSelectOne(inVO);
	}

	@Override
	public int doUpdate(UserVO inVO) throws SQLException {
		return userDao.doUpdate(inVO);
	}

	@Override
	public int doInsert(UserVO inVO) throws SQLException {
		return userDao.doInsert(inVO);
	}

	@Override
	public int idCheck(UserVO inVO) throws SQLException {
		return userDao.idCheck(inVO);
	}

	@Override
	public int passCheck(UserVO inVO) throws SQLException {
		return userDao.passCheck(inVO);
	}

	@Override
	public MessageVO idPassCheck(UserVO inVO) throws SQLException {
        //msgId;//메시지 ID
		//1. ID확인 : 10
		//2. 비번확인: 20
		//3. id/비번 통과: 30
		MessageVO  message=new MessageVO();
		int flag = userDao.idCheck(inVO);
		if(1 != flag) {
			message.setMsgId("10");
			message.setMsgContents("아이디를  확인 하세요.\n"+inVO.getuId());
			return message;
		}
		
		flag = userDao.passCheck(inVO);
		if(1 != flag) {
			message.setMsgId("20");
			message.setMsgContents(inVO.getuId()+ "의 비번을 확인 하세요.");
			
			return message;
		}		
		
		
		message.setMsgId("30");
		message.setMsgContents(inVO.getuId()+ "의 아이디, 비번이 확인 되었습니다.");
		
		
		return message;
	}

}



