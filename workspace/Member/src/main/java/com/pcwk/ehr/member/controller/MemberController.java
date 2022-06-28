package com.pcwk.ehr.member.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.member.domain.MemberVO;
import com.pcwk.ehr.member.service.MemberService;
import com.pcwk.ehr.cmn.DTO;
@Controller("memberController")
@RequestMapping("/member/*")
public class MemberController {
	 final Logger LOG = LogManager.getLogger(getClass());
	   
	   final String VIEW_NAME = "member/memJoinOK";
	   
	   @Autowired
	   MemberService memberService;
	   
	   public MemberController() {}
	   
	   @RequestMapping(value = "/userView.do", method = RequestMethod.GET)
	   public String userView(Model model, SearchVO inVO) throws SQLException {
	      LOG.debug("=================================");
	      LOG.debug("userView()");
	      LOG.debug("=================================");
	      
	      //페이지 사이즈
	      if(0 == inVO.getPageSize()) {
	         inVO.setPageSize(10);
	      }
	      
	      //페이지 번호
	      if(0 == inVO.getPageNum()) {
	         inVO.setPageNum(1);
	      }
	      
	      //검색구분
	      if(null == inVO.getSearchDiv()) {
	         inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv(), ""));
	      }
	      
	      //검색어
	      if(null == inVO.getSearchWord()) {
	         inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(), ""));
	      }
	      
	      LOG.debug("==============================");
	      LOG.debug("inVO "+ inVO);
	      LOG.debug("==============================");
	      
	      List<MemberVO> list = memberService.doRetrieve(inVO);
	      
	      int totalCnt = 0;
	      // 총글수 : paging 사용
	      //if(list != null && list.size()>0) {
	    	  //totalCnt = list.get(0).getTotalCnt();
	     // }
	      
	      model.addAttribute("totalCnt", totalCnt);
	      model.addAttribute("list", list);
	      
	      ///WEB-INF/views/user/user_mng.jsp
	      return VIEW_NAME;
	   }
	   
	//GET방식으로 : http://localhost:8081/ehr/user/doSelectOne.do?uId=p08
	  
	   @RequestMapping(value="/doRetrieve.do", produces = "application/json;charset=UTF-8")
	   @ResponseBody//스프링에서 비동기 처리를 하는 경우ㅜ HTTP 요청의 본문 body 부분이 그대로 전달된다
	   public String doRetrieve(SearchVO inVO) throws SQLException{
	      String jsonString = "";
	      LOG.debug("==============================");
	      LOG.debug("inVO "+ inVO);
	      LOG.debug("==============================");
	      
	      //페이지 사이즈
	      if(0 == inVO.getPageSize()) {
	         inVO.setPageSize(10);
	      }
	      
	      //페이지 번호
	      if(0 == inVO.getPageNum()) {
	         inVO.setPageNum(1);
	      }
	      
	      //검색구분
	      if(null == inVO.getSearchDiv()) {
	         inVO.setSearchDiv(StringUtil.nvl(inVO.getSearchDiv(), ""));
	      }
	      
	      //검색어
	      if(null == inVO.getSearchWord()) {
	         inVO.setSearchWord(StringUtil.nvl(inVO.getSearchWord(), ""));
	      }
	      
	      LOG.debug("==============================");
	      LOG.debug("inVO "+ inVO);
	      LOG.debug("==============================");
	      
	      List<MemberVO> list = memberService.doRetrieve(inVO);
	      Gson gson = new Gson();
	      jsonString = gson.toJson(list);
	      
	      LOG.debug("==============================");
	      LOG.debug("jsonString "+ jsonString);
	      LOG.debug("==============================");
	      
	      return jsonString;
	   }
}
