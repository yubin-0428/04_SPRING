package com.pcwk.ehr.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingAop {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	public void logging(JoinPoint joinPoint) {
		Signature signature = joinPoint.getSignature();
		// 메소드 이름
		String methodName = signature.getName();
		LOG.debug("===========================");
		LOG.debug("=methodName=="+methodName);
		LOG.debug("===========================");
	}
	
}
