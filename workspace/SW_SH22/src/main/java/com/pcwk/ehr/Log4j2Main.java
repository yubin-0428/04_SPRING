package com.pcwk.ehr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Main {
    final static Logger  LOG = LogManager.getLogger(Log4j2Main.class);
    
	public static void main(String[] args) {
	    LOG.debug("===========================");
	    LOG.debug("Hello, world!");
	    LOG.debug("===========================");
	    System.out.println("**************");

	}

}
  