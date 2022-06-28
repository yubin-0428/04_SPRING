package com.pcwk.ehr.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pcwk.ehr.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	 final Logger LOG = LogManager.getLogger(getClass());
	   
	   @Autowired
	   MemberService memberService;
	   
	   public MemberController() {}
	   
	   //GET방식으로 : http://localhost:8081/ehr/user/doSelectOne.do?uId=p08
	  
	   @RequestMapping(value="/member.do", method=RequestMethod.GET
			   ,produces = "application/json;charset=UTF-8")
	   @ResponseBody//스프링에서 비동기 처리를 하는 경우ㅜ HTTP 요청의 본문 body 부분이 그대로 전달된다
	   public String member(){
	      LOG.debug("==============================");
	      LOG.debug("member()");
	      LOG.debug("==============================");
	      
	      
	      return "member/member";
	   }
}
