/**
* <pre>
* com.pcwk.ehr.main.controller
* Class Name : MainController.java
* Description:
* Author: ITSC
* Since: 2022/06/23
* Version 0.1
* Copyright (C) by KandJang All right
* Modification Information
* 수정일   수정자    수정내용
*-----------------------------------------------------
*2022/06/23 최초생성
*-----------------------------------------------------
* </pre>
*/
package com.pcwk.ehr.main.controller;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ITSC
 *
 */

@Controller("mainController")
@RequestMapping("main")
public class MainController {

	final Logger LOG = LogManager.getLogger(getClass());
	
	
	public MainController() {
		LOG.debug("===========================");
		LOG.debug("=MainController()=");
		LOG.debug("===========================");		
		
	}
	
	@RequestMapping(value="/mainView.do", method=RequestMethod.GET)
	public String mainView()throws SQLException{
		
		// /WEB-INF/views/main/main.jsp
		return "main/main";
	}
	
}
