package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class JTest01 {
	
		final Logger LOG = LogManager.getLogger(this.getClass());
/**
 1. 테스트 메소드는 public선언
 2. 메소드에 @Test를 붙여준다.
 */
		
		@Test
		public void test() {
			LOG.debug("=======================");
			LOG.debug("=test()=");
			LOG.debug("=======================");
		}
		
		/*
		 * private은 @Test와 같이 사용할 수 없다.
		 */
		
		@Test
		public void test02() {
			LOG.debug("=======================");
			LOG.debug("=test02()=");
			LOG.debug("=======================");
		}
		
		@Test
		public void test03() {
			LOG.debug("=======================");
			LOG.debug("=test03()=");
			LOG.debug("=======================");
		}
		
}
