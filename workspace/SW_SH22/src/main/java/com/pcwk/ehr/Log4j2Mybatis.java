package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Mybatis {
    final static Logger LOG = LogManager.getLogger(Log4j2Mybatis.class);
	public static void main(String[] args) {
        System.out.println("--------------");
        LOG.debug("This is a debug message");
        LOG.info("This is an info message");
        LOG.warn("This is a warn message");
        LOG.error("This is an error message");
        LOG.fatal("This is a fatal message");  
        System.out.println("--------------");
	}

}

