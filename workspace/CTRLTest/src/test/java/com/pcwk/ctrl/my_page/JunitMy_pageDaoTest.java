package com.pcwk.ctrl.my_page;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.my_page.dao.My_pageDao;

@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
}) //applicationContext.xml loading
public class JunitMy_pageDaoTest {
	
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired  //컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	My_pageDao dao;
	MemberVO member01;

	@Before
	public void setUp() throws Exception {
		LOG.debug("====================");
		LOG.debug("=0.setUp()=");
		LOG.debug("====================");
		
		member01 = new MemberVO("1", "최유빈", "yubin@naver.com", "010-1111-1111","서울특별시 마포구 서강로 136 아이비타워 2,3층","2");
		
		LOG.debug("context:"+context);
		LOG.debug("dao:"+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
	}

	@Test
	public void memberList() throws SQLException {
		  List<MemberVO> list = dao.memberList();
		  for(MemberVO vo:list) {
			  LOG.debug("vo="+vo);
		  }
	  }

}
