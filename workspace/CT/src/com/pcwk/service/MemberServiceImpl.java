package com.pcwk.service;

import javax.xml.ws.ServiceMode;

import com.pcwk.dao.MemberDAO;
import com.pcwk.domain.MemberVO;

@ServiceMode
public class MemberServiceImpl implements MemberService {

	//DB와 연결 (의존주입)
	@Inject
	private MemberDAO idao;
	

	//회원정보보기
	@Override
	public MemberVO readinfo(String id) {
		System.out.println("S : readMember()실행");
		MemberVO vo = null;
		
		try {
			vo = idao.readinfo(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	
}