package com.pcwk.ctrl.member;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.member.dao.MemberDao;


@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
}) //applicationContext.xml loading
public class JunitMemberDaoTest {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired	////컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입	
	ApplicationContext context;
	
	@Autowired
	MemberDao dao;
	MemberVO  member01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=================");
		LOG.debug("=0.setUp()=");
		LOG.debug("=================");
		
		member01 = new MemberVO("11111","테스트","test@naver.com","010-1234-5678","서울특별시 마포구","2");
		
		LOG.debug("context:"+context);
		LOG.debug("dao:"+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
	}


	@Test
	public void doMemberInsert() throws SQLException {
		LOG.debug("=================");
		LOG.debug("=1.doMemberInsert()=");
		LOG.debug("=================");
		
		//1. 삭제
		
		//2. 등록
		dao.doMemberInsert(member01);
		
	}

}
