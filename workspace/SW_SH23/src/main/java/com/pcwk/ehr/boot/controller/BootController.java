package com.pcwk.ehr.boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("boot")
public class BootController {
    final Logger LOG=LogManager.getLogger(getClass());
    
	@RequestMapping(value = "/bootList.do",method = RequestMethod.GET)
	public String bootList() {
		LOG.debug("========================");
		LOG.debug("=bootList()=");
		LOG.debug("========================");
		
		///WEB-INF/views/+ boot/boot_list+ .jsp
		///WEB-INF/views/boot/boot_list.jsp
		return "boot/boot_list";
	}
	
	@RequestMapping(value = "/bootReg.do",method = RequestMethod.GET)
	public String bootReg() {
		LOG.debug("========================");
		LOG.debug("=bootReg()=");
		LOG.debug("========================");
		
		///WEB-INF/views/+ boot/boot_list+ .jsp
		///WEB-INF/views/boot/boot_list.jsp
		return "boot/boot_reg";    
	}
	
	@RequestMapping(value = "/tmpMenu.do",method = RequestMethod.GET)
	public String tmpMenu() {
		LOG.debug("========================");
		LOG.debug("=tmpMenu()=");
		LOG.debug("========================");
		
		///WEB-INF/views/+ boot/boot_list+ .jsp
		///WEB-INF/views/boot/boot_list.jsp
		return "menu/tmp_menu";    
	}
	
}

