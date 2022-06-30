package com.pcwk.ctrl.menu.dao;

import java.sql.SQLException;
import java.util.List;

import com.pcwk.ctrl.cmn.ProductVO;

public interface MenuDao {
	
	/**
	 * 카테고리(메뉴)
	 * @return List<ProductVO>
	 * @throws SQLException
	 */
	public List<ProductVO> menuList();
}
