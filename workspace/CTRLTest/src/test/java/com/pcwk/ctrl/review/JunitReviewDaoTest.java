package com.pcwk.ctrl.review;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.cmn.RdVO;
import com.pcwk.ctrl.cmn.ReviewRdVO;
import com.pcwk.ctrl.cmn.ReviewVO;
import com.pcwk.ctrl.cmn.SearchVO;
import com.pcwk.ctrl.productDetail.dao.ProductDetailDao;
import com.pcwk.ctrl.review.dao.ReviewDao;

@RunWith(SpringJUnit4ClassRunner.class) // JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
		
}) // applicationContext.xml loading
public class JunitReviewDaoTest {
	final Logger LOG = LogManager.getLogger(this.getClass());
	
	@Autowired // 컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	
	@Autowired
	ReviewDao reviewDao;
	
	@Autowired
	ProductDetailDao productDetailDao;
	
	ReviewVO review01;
	ProductVO product01;
	RdVO rd01;
	MemberVO member01;

	SearchVO searchVO;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=0. setUp()=");
		LOG.debug("=======================");
		
		review01 = new ReviewVO(14, "1", 1, "안녕하세요, junitReviewrDaoTest입니다.", "kjh", "날짜_사용안함");
		product01 = new ProductVO("plate06", "plate", "디너플레이트 라 빅토리", 180000, "27cm");
		rd01 = new RdVO(14, "감사합니다! 다음에도 또 이용해주세요", "날짜_사용안함" , "관리자", "55555");
		searchVO = new SearchVO(10, 1, "", "");
		
		LOG.debug("context:"+context);
		LOG.debug("reviewDao:"+reviewDao);
		
		assertNotNull(context);
		assertNotNull(reviewDao);
	}
	
	@Test
	//@Ignore
	public void doReviewRetrieve() throws SQLException {
		// 1. param 값 확인(pNum : 상품번호)
		// 2. 리뷰, 댓글 테이블 조회

		// 1.
		ProductVO paramVO = productDetailDao.doProductDetailSelect(product01);
		isProductSameData(paramVO, product01);
		
		// 2.
		Map<String, Object> inVO = new HashMap<String, Object>();
		LOG.debug(product01.getpNum());
		inVO.put("pNum", product01.getpNum());
		inVO.put("pageNum", searchVO.getPageNum());
		inVO.put("pageSize", searchVO.getPageSize());
		
		List<ReviewRdVO> list = reviewDao.doReviewsRetrieve(inVO);
		for(ReviewRdVO vo : list) {
			LOG.debug("vo="+vo);
		}
	}
	
	@Test
	@Ignore
	public void AddAndGet() throws SQLException {
		// 1. 리뷰 1건 등록
		// 2. 단건 조회
		// 3. 리뷰 1건 데이터 수정
		// 4. 비교
		
		// 5. 관리자 댓글 1건 등록
		// 6. 단건 조회
		// 7. 관리자 댓글 1건 데이터 수정
		// 8. 비교
		
		// 1.
		reviewDao.doReviewInsert(review01);
		assertEquals(1, reviewDao.getCount(review01));
		
		// 2.
		ReviewVO outVO = reviewDao.doSelectOne(review01);
		String upString = "_U";
		outVO.setrContent(outVO.getrContent()+upString);
		LOG.debug(outVO.getrContent()+upString);
		// 3. 
		reviewDao.reviewUpdate(outVO);
		
		// 4.
		ReviewVO resultVO = reviewDao.doSelectOne(outVO);
		isReviewSameData(outVO, resultVO);
		
		
		// 5.
		reviewDao.doRdInsert(rd01);
		assertEquals(1, reviewDao.getRdCount(rd01));
		
		// 6. 
		RdVO outVO2 = reviewDao.doRdSelectOne(rd01);
		outVO2.setRdCon(outVO2.getRdCon()+upString);
		
		// 7.
		reviewDao.rdUpdate(outVO2);
		
		// 8.
		RdVO resultVO2 = reviewDao.doRdSelectOne(outVO2);
		isRdSameData(outVO2, resultVO2);
	}

    private void isReviewSameData(ReviewVO voVO, ReviewVO orgVO) {
	      assertEquals(voVO.getrNum(), orgVO.getrNum());
	      assertEquals(voVO.getdNum(), orgVO.getdNum());

	      assertEquals(voVO.getoNum(), orgVO.getoNum());
	      assertEquals(voVO.getrContent(), orgVO.getrContent());
	      assertEquals(voVO.getoName(), orgVO.getoName());
    }
    
    private void isProductSameData(ProductVO voVO, ProductVO orgVO) {
	      assertEquals(voVO.getpNum(), orgVO.getpNum());
	      assertEquals(voVO.getpCategory(), orgVO.getpCategory());

	      assertEquals(voVO.getpName(), orgVO.getpName());
	      assertEquals(voVO.getpPrice(), orgVO.getpPrice());
	      assertEquals(voVO.getpSize(), orgVO.getpSize());    
    }
    
    private void isRdSameData(RdVO voVO, RdVO orgVO) {
    	assertEquals(voVO.getrNum(), orgVO.getrNum());
    	assertEquals(voVO.getRdCon(), orgVO.getRdCon());
    	
    	assertEquals(voVO.getRdName(), orgVO.getRdName());
    	assertEquals(voVO.getmNum(), orgVO.getmNum());    
    }
    
	@After
	public void tearDown() throws Exception {
		LOG.debug("=======================");
		LOG.debug("=9. tearDown()=");
		LOG.debug("=======================");
		
	}
	
}
