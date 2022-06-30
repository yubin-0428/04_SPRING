package com.pcwk.ctrl.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cmn.MemberVO;


@Controller("loginController")
@RequestMapping("login")
public class LoginController<OAuth2AccessToken> {

	final Logger LOG = LogManager.getLogger(getClass());
	private Object apiResult;
	
	public LoginController () {}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.GET)
	public String loginPageGET() {
		LOG.debug("=================================");
		LOG.debug("loginPageGET()");
		LOG.debug("=================================");
		
		return "login/naver_login";
	}
	
	@RequestMapping(value = "/callback.do")
	public String naverLogin(MemberVO inVO, HttpServletRequest req) throws Exception {
		
		
		LOG.debug("=================================");
		LOG.debug("naverLogin()");
		LOG.debug("=================================");
		
		
		
		return "login/naver_callback";
	}
	

}
