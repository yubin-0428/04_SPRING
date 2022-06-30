package com.pcwk.ctrl.menu;

import static org.junit.Assert.assertNotNull;

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

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.menu.dao.MenuDao;

@WebAppConfiguration 
@RunWith(SpringJUnit4ClassRunner.class) //JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"		
}) //applicationContext.xml loading

public class JunitMenuDaoTest {

	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired  //컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	MenuDao dao;
	ProductVO product01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("====================");
		LOG.debug("=0.setUp()=");
		LOG.debug("====================");
		
		product01 = new ProductVO("bowls01","bowls","메트로시크 샐러드볼",242000,"23cm");
	
		LOG.debug("context:"+context);
		LOG.debug("dao:"+dao);
		
		assertNotNull(context);
		assertNotNull(dao);
	}

	@Test
	public void test() {
		List<ProductVO> list = dao.menuList();
		for(ProductVO vo : list) {
			LOG.debug("vo="+vo);
		}
	}

}
