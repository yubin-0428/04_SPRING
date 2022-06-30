package com.pcwk.ctrl.pay.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pay")
public class PayController {
	final Logger LOG = LogManager.getLogger(getClass());
	
	@RequestMapping(value = "/payAfter.do", method = RequestMethod.GET)
	public String payAfter() {
		LOG.debug("====================");
		LOG.debug("=after()=");
		LOG.debug("====================");
		
		return "pay/pay_after";
		//http://localhost:8081/ctrl/ctrl/after.do
	}
	
	@RequestMapping(value = "/payBefore.do", method = RequestMethod.GET)
	public String payBefore() {
		LOG.debug("====================");
		LOG.debug("=before()=");
		LOG.debug("====================");
		
		return "pay/pay_before";
		//http://localhost:8081/ctrl/ctrl/before.do
	}
	
	@RequestMapping(value = "/payco.do", method = RequestMethod.GET)
	public String payco() {
		LOG.debug("====================");
		LOG.debug("=before()=");
		LOG.debug("====================");
		
		return "pay/payco";
		//http://localhost:8081/ctrl/ctrl/before.do
	}
	
}
