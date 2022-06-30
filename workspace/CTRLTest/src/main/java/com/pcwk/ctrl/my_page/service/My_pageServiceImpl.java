package com.pcwk.ctrl.my_page.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcwk.ctrl.cmn.MemberVO;
import com.pcwk.ctrl.my_page.dao.My_pageDaoImpl;

@Service
public class My_pageServiceImpl implements My_pageService {

	@Autowired
	My_pageDaoImpl my_pageDao;
	
	@Override
	public List<MemberVO> memberList(){
		return my_pageDao.memberList();
	}
	
}
