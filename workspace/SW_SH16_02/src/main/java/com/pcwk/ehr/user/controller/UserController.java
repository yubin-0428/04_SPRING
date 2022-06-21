package com.pcwk.ehr.user.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.user.domain.UserVO;
import com.pcwk.ehr.user.service.UserService;

@Controller("userController")
public class UserController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	UserService userService;
	
	public UserController() {}

	// GET 방식으로 : http://localhost:8081/ehr/user/doSelectOne.do
	@RequestMapping(value = "user/doSelectOne.do", method=RequestMethod.GET
			, produces = "application/json;charset=UTF-8")
	@ResponseBody // 스프링에서 비동기 처리를 하는 경우, Http 요청의 본문body부분이 전달된다.
	//UserVO inVO : form name VO 멤버 변수명이 동일하면 자동으로 매핑한다.
	public String doSelectOne(UserVO inVO) throws SQLException{
		LOG.debug("================================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("================================");
		
		UserVO outVO = userService.doSelectOne(inVO);
		Gson gson = new Gson();
		String jsonString = gson.toJson(outVO); 
		
		LOG.debug("=================================");
		LOG.debug("=jsonString="+jsonString);
		LOG.debug("=================================");
		
		return jsonString;
	}
	
}
