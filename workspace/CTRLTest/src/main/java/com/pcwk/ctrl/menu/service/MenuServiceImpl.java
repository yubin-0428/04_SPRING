package com.pcwk.ctrl.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.ProductVO;
import com.pcwk.ctrl.menu.dao.MenuDaoImpl;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuDaoImpl menuDao;
	
	@Override
	public List<ProductVO> menuList(){
		return menuDao.menuList();
	}
}
