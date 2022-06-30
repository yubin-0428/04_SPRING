package com.pcwk.ctrl.productDetail;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.productDetail.dao.ProductDetailDao;
import com.pcwk.ctrl.review.dao.ReviewDao;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JunitProductDetailDaoTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	ProductDetailDao productDetailDao;
	ProductVO product01;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		product01 = new ProductVO("glass07", "glass", "뉴웨이브 데일리 글라스", 2700, "270ml");
		
		LOG.debug("context:"+context);
		LOG.debug("productDetailDao:"+productDetailDao);
		
		assertNotNull(context);
		assertNotNull(productDetailDao);
	}
	
	@Test
	public void doSelectOne() throws SQLException {
		// 1. 1건 조회
		ProductVO outVO = productDetailDao.doProductDetailSelect(product01);
		LOG.debug("outVO : " + outVO);
		// 2. 비교
	    isSameData(outVO, product01);
	}

    private void isSameData(ProductVO voVO, ProductVO orgVO) {
	      assertEquals(voVO.getpNum(), orgVO.getpNum());
	      assertEquals(voVO.getpName(), orgVO.getpName());
	      assertEquals(voVO.getpPrice(), orgVO.getpPrice());
	      assertEquals(voVO.getpSize(), orgVO.getpSize());
    }
    
	@After
	public void tearDown() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=9. tearDown()=");
		LOG.debug("=======================");
		
	}
	
}
