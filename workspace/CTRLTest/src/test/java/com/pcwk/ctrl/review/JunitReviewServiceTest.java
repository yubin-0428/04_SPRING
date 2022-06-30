package com.pcwk.ctrl.review;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.review.dao.ReviewDao;
import com.pcwk.ctrl.review.service.ReviewService;

// 테스트 메소드 수행 순서 : a~z순으로 작동
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class JunitReviewServiceTest {
	final Logger LOG = LogManager.getLogger(this.getClass());

	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ReviewDao reviewDao;
	
	ReviewVO review01;
	
	@Autowired
	PlatformTransactionManager transactionManager;

	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");

		review01 = new ReviewVO(22, "1", 1, "안녕하세요, junitReviewServiceTest입니다.", "kjh", "날짜_사용안함");
		
		LOG.debug("context:" + context);
		LOG.debug("reviewService:" + reviewService);
		LOG.debug("transactionManager:" + transactionManager);
		
		assertNotNull(context);
		assertNotNull(reviewService);
		assertNotNull(transactionManager);
	}

	@Test
	public void doReviewInsert() throws SQLException {
		this.reviewService.doReviewInsert(review01);
		assertEquals(1, reviewDao.getCount(review01));
		
		this.reviewDao.doSelectOne(review01);
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
