package com.pcwk.ehr;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitLifeCycle02 {

	final Logger LOG = LogManager.getLogger(JUnitLifeCycle02.class);
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("=========================");
		LOG.debug("=0 setUp()=");
		LOG.debug("=========================");
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("=========================");
		LOG.debug("=9 tearDown()=");
		LOG.debug("=========================");
	}

	@Test
	public void test() {
		LOG.debug("=========================");
		LOG.debug("=-1 test()=");
		LOG.debug("=========================");
	}


	@Test
	public void test02() {
		LOG.debug("=========================");
		LOG.debug("=-2 test02()=");
		LOG.debug("=========================");
	}

}
