package com.pcwk.ehr.member.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.member.domain.MemberVO;
import com.pcwk.ehr.member.service.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	
	 final Logger LOG = LogManager.getLogger(getClass());
	   
	   @Autowired
	   MemberService memberService;
	   
	   public MemberController() {}
	   
	   @RequestMapping(value="/list.do", method=RequestMethod.GET)
		public String memberList(Model model) {
			LOG.debug("==========================");
			LOG.debug("memberList()");
			LOG.debug("==========================");
			
			List<MemberVO> list = memberService.memberList();
			model.addAttribute("list", list);
			///WEB-INF/views/user/user_mng.jsp
			return "member/member_list";
			
		}
	   
	   
	   @RequestMapping(value = "/memberMenu.do", method = RequestMethod.GET)
		public String memberMenu() {
			LOG.debug("=================================");
			LOG.debug("memberMenu()");
			LOG.debug("=================================");
			
			///WEB-INF/views/ + boot/boot_list + .jsp
			///WEB-INF/views/boot/boot_list.jsp
			return "menu/member_menu";
		}
}
