package com.pcwk.controller;

public class InfoController {
	/* 회원정보보기 */
	// http://localhost:8088/test/member/info
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void infoGET(HttpSession session, Model model) throws Exception{

		//세션 객체 안에 있는 ID정보 저장
		String id = (String) session.getAttribute("id");
		l.info("C: 회원정보보기 GET의 아이디 "+id);

		//서비스안의 회원정보보기 메서드 호출
		MemberVO vo = service.readMember(id);

		//정보저장 후 페이지 이동
		model.addAttribute("memVO", vo);
		l.info("C: 회원정보보기 GET의 VO "+ vo);
	}

}
