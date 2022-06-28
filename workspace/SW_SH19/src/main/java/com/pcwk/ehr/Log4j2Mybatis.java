package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Mybatis {

	final static Logger LOG = LogManager.getLogger(Log4j2Mybatis.class);
	public static void main(String[] args) {
		System.out.println("------------------");
		LOG.debug("===========================");
		LOG.debug("=Log4j2Mybatis=");
		LOG.debug("===========================");
		
	}

}
