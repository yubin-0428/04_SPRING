package com.pcwk.ehr.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pcwk.ehr.cmn.MemberVO;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	
	// mybatis db 연결객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<MemberVO> memberList(){     // 호출매퍼.호출ID
		return sqlSessionTemplate.selectList("com.pcwk.ehr.member.memberList");
	}
		
	}
