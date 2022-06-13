package com.pcwk.ehr.anno.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ehr.anno.domain.AnnoVO;
import com.pcwk.ehr.anno.service.AnnoService;

@Controller
public class AnnoController {
	
	@Autowired
	private AnnoService annoService;
	
	public AnnoController() {}
	
	@RequestMapping(value="anno/annoView.do")
	public String annoView() {
		System.out.println("======================");
		System.out.println("=AnnoController=annoView()=");
		System.out.println("======================");
		
		return "anno/anno";
	}
	
	@RequestMapping(value="anno/doSelectOne.do",method = RequestMethod.POST)
	public String doSelectOne(Model model, HttpServletRequest req) throws SQLException {
		String userId = req.getParameter("userId");
		String passwd = req.getParameter("passwd");
		
		System.out.println("======================");
		System.out.println("=userId="+userId);
		System.out.println("=passwd="+passwd);
		System.out.println("======================");
		
		AnnoVO inVO = new AnnoVO();
		inVO.setPasswd(passwd);
		inVO.setUserId(userId);
		
		AnnoVO outVO = annoService.doSelectOne(inVO);
		model.addAttribute("vo", outVO);
		
		return "anno/anno";
	}
	
}
