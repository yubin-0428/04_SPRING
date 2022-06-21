package com.pcwk.service;

import com.pcwk.domain.MemberVO;

	public interface MemberService {

		//회원정보 보기
		public MemberVO readMember(String id);
}
