package com.pcwk.ctrl.menu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.ProductVO;

@Repository
public class MenuDaoImpl implements MenuDao {
	
	// mybatis db 연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<ProductVO> menuList(){
		return sqlSessionTemplate.selectList("com.pcwk.ctrl.menu.menuList");
	}
}
