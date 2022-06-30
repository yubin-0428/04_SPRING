package com.pcwk.ctrl.my_page.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ctrl.cmn.MemberVO;

@Repository
public class My_pageDaoImpl implements My_pageDao {
	
	// mybatis db 연결객체
		@Autowired
		SqlSessionTemplate sqlSessionTemplate;
		
		@Override
		public List<MemberVO> memberList(){     // 호출매퍼.호출ID
			return sqlSessionTemplate.selectList("com.pcwk.ctrl.my_page.memberList");
		}
}
