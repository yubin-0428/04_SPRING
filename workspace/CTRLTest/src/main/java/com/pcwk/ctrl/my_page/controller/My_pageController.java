package com.pcwk.ctrl.my_page.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.my_page.service.My_pageService;
import com.pcwk.ctrl.cmn.MemberVO;


@Controller
public class My_pageController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	   
	   @Autowired
	   My_pageService memberService;
	   
	   public My_pageController() {}
	   
	   // 회원목록
	   @RequestMapping(value="/my_page.do", method=RequestMethod.GET)
		public String memberList(Model model) {
			LOG.debug("==========================");
			LOG.debug("memberList()");
			LOG.debug("==========================");
			
			List<MemberVO> list = memberService.memberList();
			model.addAttribute("list", list);
			return "my_page/my_page";
			
		}
}
