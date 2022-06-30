package com.pcwk.ctrl.order;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.pcwk.ctrl.cmn.DTO;
import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.cmn.OrderVO;
import com.pcwk.ctrl.order.dao.OrderDao;

public class JunitorderDaoTest {

	final Logger LOG = LogManager.getLogger(this.getClass());
	  
	@Autowired  //컨텍스트 프레임워크는 변수 타입과 일치하는 컨텍스트 내의 빈을 찾고, 변수에 주입
	ApplicationContext context;
	    
	@Autowired
	OrderDao dao;
	OrderVO order01;
	MemberVO memberVO;
	
	@Before
	public void setUp() throws Exception {
		  LOG.debug("====================");
		  LOG.debug("=0.setUp()=");
		  LOG.debug("====================");
		  
		  order01=new OrderVO(2222, "서울특별시 마포구 서강로 136 아이비타워 2,3층", "최유빈","010-1111-1111","20","날짜사용안함","1");
		  
		  
		  LOG.debug("context:"+context);
		  LOG.debug("dao:"+dao);
		  
		  assertNotNull(context);
		  assertNotNull(dao);
	}

	
}
