package com.pcwk.ehr.aspectj;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//테스트 메소드 수행 순서: a-z순으로 작동
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)//JUnit기능을 스프링 프레임으로 확장!
@ContextConfiguration(locations = "/com/pcwk/ehr/aspectj/aspectj-around-applicationContext.xml")

public class JunitAspectjAround {
	final Logger LOG = LogManager.getLogger(this.getClass());
	   
	@Autowired
	ApplicationContext context;
	   
	@Autowired
	Member member;
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("===========================");
	    LOG.debug("=0.setUp()=");
	    LOG.debug("===========================");
	    
	    LOG.debug("context:"+context);
	    LOG.debug("member:"+member);
	    
	    assertNotNull(context);
	    assertNotNull(member);
	}

	@Test
	public void aroundApect() {
		member.doSave();
	}

}
