package com.pcwk.ctrl.main.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("mainController")
@RequestMapping("main")
public class MainController {
    final Logger LOG=LogManager.getLogger(getClass());
    
    public MainController() {}
    
	@RequestMapping(value = "/main.do",method = RequestMethod.GET)
	public String mainPageGET() throws SQLException {
		LOG.debug("========================");
		LOG.debug("=mainPageGET()=");
		LOG.debug("========================");
		
		///WEB-INF/views/+ boot/boot_list+ .jsp
		///WEB-INF/views/boot/boot_list.jsp
		return "main/main";
	}
	
}

