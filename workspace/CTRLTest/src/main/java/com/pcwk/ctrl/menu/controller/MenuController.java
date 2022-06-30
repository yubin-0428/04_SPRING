package com.pcwk.ctrl.menu.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.menu.service.MenuService;

@Controller
public class MenuController {
	
	final Logger LOG = LogManager.getLogger(getClass());
	
	@Autowired
	MenuService menuService;
	
	public MenuController() {}
	
	// 메뉴 목록
	@RequestMapping(value="/menuList.do", method=RequestMethod.GET)
	public String menuList(Model model) {
		LOG.debug("==========================");
		LOG.debug("menuList()");
		LOG.debug("==========================");
		
		List<ProductVO> list = menuService.menuList();
		model.addAttribute("list", list);
		return "menu/menu_list";
	}
}
