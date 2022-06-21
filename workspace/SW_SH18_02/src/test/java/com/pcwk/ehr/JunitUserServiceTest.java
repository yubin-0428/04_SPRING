package com.pcwk.ehr;

import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.pcwk.ehr.user.service.UserServiceImpl.MIN_RECOMMEND_FOR_GOLD;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.Level;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

import jdk.nashorn.internal.runtime.ECMAErrors;

// 테스트 메소드 수행 순서 : a~z순으로 작동
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class JunitUserServiceTest {
	final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;

	@Autowired // 주로 변수 위에 설정하여 해당 타입의 객체를 찾아서 자동으로 할당한다.
	UserService userService;

	@Autowired
	UserDao dao;

	@Autowired
	DataSource dataSource;

	List<UserVO> list;

	@Autowired
	PlatformTransactionManager transactionManager;

	// @Autowired
	// @Qualifier("dummyMailSender")
	@Resource(name = "dummyMailSender")
	MailSender mailSender;

	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		/*
		 * 사용자 레벨은 BASIC, SLIVER, GOLD 사용자가 처음 가입하면 : BASIC 가입 이후 50회 이상 로그인 하면 : SILVER
		 * SILVER레벨이면서 30번 이상 추천을 받으면 GOLD로 레벨 UP. 사용자 레벨의 변경 작업은 일정한 주기를 가지고 일괄처리.(트랜잭션
		 * 관리)
		 */
		list = Arrays.asList(new UserVO("p07", "이은빈07", "4321", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0,
				"joohea5943@naver.com", "날짜_사용안함") // BASIC
				, new UserVO("p070", "김주혜070", "4321", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 10, "joohea5943@naver.com",
						"날짜_사용안함") // BASIC -> SILVER
				, new UserVO("p0700", "김주혜0700", "4321", Level.SILVER, MIN_LOGCOUNT_FOR_SILVER + 1,
						MIN_RECOMMEND_FOR_GOLD - 1, "joohea5943@naver.com", "날짜_사용안함") // SILVER -> SILVER
				, new UserVO("p07000", "김주혜07000", "4321", Level.SILVER, MIN_LOGCOUNT_FOR_SILVER + 1,
						MIN_RECOMMEND_FOR_GOLD, "joohea5943@naver.com", "날짜_사용안함") // SILVER -> GOLD
				, new UserVO("p070000", "김주혜07000", "4321", Level.GOLD, MIN_LOGCOUNT_FOR_SILVER + 2,
						MIN_RECOMMEND_FOR_GOLD + 1, "joohea5943@naver.com", "날짜_사용안함") // GOLD
		);

		LOG.debug("context:" + context);
		LOG.debug("userService:" + userService);
		LOG.debug("dao:" + dao);
		LOG.debug("dataSource:" + dataSource);
		LOG.debug("transactionManager:" + transactionManager);
		LOG.debug("javaMailSenderImpl:" + mailSender);

		assertNotNull(context);
		assertNotNull(userService);
		assertNotNull(dao);
		assertNotNull(dataSource);
		assertNotNull(transactionManager);
		assertNotNull(mailSender);
	}

	private void isSameUser(UserVO vsVO, UserVO orgVO) {
		assertEquals(vsVO.getuId(), orgVO.getuId());
		assertEquals(vsVO.getName(), orgVO.getName());
		assertEquals(vsVO.getPasswd(), orgVO.getPasswd());
		
		assertEquals(vsVO.getLevel(), orgVO.getLevel());
		assertEquals(vsVO.getLogin(), orgVO.getLogin());
		assertEquals(vsVO.getRecommend(), orgVO.getRecommend());
		assertEquals(vsVO.getEmail(), orgVO.getEmail());
	}
	
	
	@Test
	public void addAndGet() {
		LOG.debug("=======================");
		LOG.debug("=1. setUp()=");
		LOG.debug("=======================");

		try {
			for(UserVO vo :list) {
				userService.doDelete(vo);
			}
			
			assertEquals(0, dao.getCount(list.get(0)));
			
			userService.add(list.get(0));
			assertEquals(1, dao.getCount(list.get(0)));
			
			userService.add(list.get(1));
			assertEquals(2, dao.getCount(list.get(0)));
			
			userService.add(list.get(2));
			assertEquals(3, dao.getCount(list.get(0)));
			
			userService.add(list.get(3));
			assertEquals(4, dao.getCount(list.get(0)));
			
			userService.add(list.get(4));
			assertEquals(5, dao.getCount(list.get(0)));
			
			
			UserVO vsUser01 = userService.doSelectOne(list.get(0));
			isSameUser(vsUser01,list.get(0));

			UserVO vsUser05 = userService.doSelectOne(list.get(4));
			isSameUser(vsUser05,list.get(4));
			
			
			
			
		} catch (SQLException e) {
			LOG.debug("----------------------");
			LOG.debug("-SQLException-" + e.getMessage());
			LOG.debug("----------------------");
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void add() throws SQLException {
		// 1. 전체 데이터 삭제
		// 2. Level이 있는 경우, Level이 Null인 경우
		// 3. 각각 추가
		// 4. 각각 데이터 조회
		// 5. 비교
		LOG.debug("=======================");
		LOG.debug("=2. add()=");
		LOG.debug("=======================");

		// 1.
		for (UserVO user : list) {
			this.dao.doDelete(user);
		}

		// 2. Level이 Null인 경우
		UserVO userWithOutLevel = list.get(0);
		userWithOutLevel.setLevel(null); // BASIC -> NULL

		// 2-1. Level이 Null이 아닌 경우(그대로 통과)
		UserVO userWithLevel = list.get(4);

		// 3.
		this.userService.add(userWithOutLevel);
		assertEquals(1, dao.getCount(list.get(0)));

		// 3-1
		this.userService.add(userWithLevel);
		assertEquals(2, dao.getCount(list.get(0)));

		// 4. 데이터 조회
		UserVO userWithOutLevelRead = this.dao.doSelectOne(userWithOutLevel);
		assertEquals(userWithOutLevelRead.getLevel(), Level.BASIC);

		// 4-1. Level이 Null이 아닌 경우 조회
		UserVO userWithLevelRead = this.dao.doSelectOne(userWithLevel);
		assertEquals(userWithLevelRead.getLevel(), userWithLevel.getLevel());
	}

	@Test
	@Ignore
	public void upgradeLevels() throws SQLException {
		LOG.debug("=======================");
		LOG.debug("=1. upgradeLevels()=");
		LOG.debug("=======================");

		// 1. 전체 데이터 삭제
		// 2. 데이터 입력
		// 3. 등업
		// 4. 등업데이터 비교

		// 1.
		for (UserVO user : list) {
			this.dao.doDelete(user);
		}

		// 2.
		for (UserVO user : list) {
			this.dao.doInsert(user);
		}

		assertEquals(5, dao.getCount(list.get(0)));

		// 3.
		try {
			this.userService.upgradeLevels(list.get(0));
		} catch (Exception e) {
			LOG.debug("--------------------------");
			LOG.debug("-Exception-" + e.getMessage());
			LOG.debug("--------------------------");
		}
		// 4.
		checkLevel(list.get(0), false);
		checkLevel(list.get(1), true); // BASIC에서 등업
		checkLevel(list.get(2), false);
		checkLevel(list.get(3), true); // SILVER에서 등업
		checkLevel(list.get(4), false);

	}

	private void checkLevel(UserVO user, boolean upgraded) throws SQLException {
		UserVO upUser = dao.doSelectOne(user);

		if (upgraded == true) { // 등업
			LOG.debug(upUser.getLevel() + "===" + user.getLevel().nextLevel());
			assertEquals(upUser.getLevel(), user.getLevel().nextLevel());
		} else {
			assertEquals(upUser.getLevel(), user.getLevel());
		}
	}

//	private void checkLevel(UserVO user, Level expectedLevel ) throws SQLException {
//		// DB에 있는 데이터 조회
//		UserVO upUser = dao.doSelectOne(user);
//		LOG.debug(upUser.getLevel()+"==="+expectedLevel);
//		assertEquals(upUser.getLevel(), expectedLevel);
//	}

	@After
	public void tearDown() throws Exception {
	}

}
