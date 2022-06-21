package com.pcwk.cyb.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pcwk.cyb.domain.MemberVO;

import oracle.net.aso.l;

public class MemberController {

	@RequestMapping("/user/member/myPage")
	public String showMypage() {
		return "user/member/myPage";

}
}


