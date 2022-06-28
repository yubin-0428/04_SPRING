package com.pcwk.ehr.board.controller;

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
import com.pcwk.ehr.board.domain.BoardVO;
import com.pcwk.ehr.board.service.BoardService;
import com.pcwk.ehr.cmn.MessageVO;
import com.pcwk.ehr.cmn.SearchVO;
import com.pcwk.ehr.cmn.StringUtil;
import com.pcwk.ehr.user.domain.UserVO;

@Controller("boardController")
@RequestMapping("board")
public class BoardController {
   
   final Logger LOG = LogManager.getLogger(getClass());
   
   @Autowired
   BoardService boardService;
   
   public BoardController() {}
   
   @RequestMapping(value="/doDelete.do", method=RequestMethod.POST
	         , produces="application/json;charset=UTF-8")
	@ResponseBody
 	public String doDelete(BoardVO inVO) throws SQLException{
	   LOG.debug("=================================");
	   LOG.debug("inVO : "+ inVO);
	   LOG.debug("=================================");
	   
	   int flag = boardService.doDelete(inVO);
	   String resultMsg = "";
	   
	   if(1==flag) {
		   resultMsg = "삭제되었습니다.";
	   }else {
		   resultMsg = " 삭제실패";
	   }
	   
	   MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
	   String jsonString = new Gson().toJson(message);
	   LOG.debug("=================================");
	   LOG.debug("jsonString : "+ jsonString);
	   LOG.debug("=================================");
	   
	   return jsonString;
 }
   
   
   @RequestMapping(value="/doSelectOne.do")
   public String doSelectOne(BoardVO inVO, Model model) throws SQLException{
	   LOG.debug("=================================");
	   LOG.debug("inVO : "+ inVO);
	   LOG.debug("=================================");
	   
	   BoardVO outVO = boardService.doSelectOne(inVO);
	   LOG.debug("=================================");
	   LOG.debug("outVO : "+ outVO);
	   LOG.debug("=================================");
	   model.addAttribute("vo", outVO);
	   
	   return "board/board_mod";
   }
   
   
   
   @RequestMapping(value="/doInsert.do", method=RequestMethod.POST
         , produces="application/json;charset=UTF-8")
   @ResponseBody
   public String doInsert(BoardVO inVO) throws SQLException{
      LOG.debug("=================================");
      LOG.debug("inVO : "+ inVO);
      LOG.debug("=================================");
      
      //최초 등록시 등록자 아이디 = 수정자 아이디
      inVO.setModId(inVO.getRegId());
      
      int flag = boardService.doInsert(inVO);
      String resultMsg = "";
      if(1 == flag) {
         resultMsg = inVO.getTitle() + "가 등록되었습니다";
      }else {
         resultMsg = "등록 실패";
      }
      
      MessageVO message = new MessageVO(String.valueOf(flag), resultMsg);
      String jsonString = new Gson().toJson(message);
      LOG.debug("=================================");
      LOG.debug("jsonString : "+ jsonString);
      LOG.debug("=================================");
      
      return jsonString;
   }
   
   @RequestMapping(value="/moveToReg.do", method=RequestMethod.GET)
   public String moveToReg(SearchVO inVO, Model model) throws SQLException{
      
      String viewName = "board/board_reg";
      LOG.debug("=================================");
      LOG.debug("moveToReg");
      LOG.debug("inVO : "+ inVO);
      LOG.debug("=================================");
      model.addAttribute("vo", inVO);
      
      return viewName;
   }
   
   @RequestMapping(value="/doRetrieve.do", method=RequestMethod.GET
         , produces="application/json;charset=UTF-8")
   @ResponseBody//스프링에서 비동기 처리를 하는 경우 HTTP 요청의 본문 body 부분이 그대로 전달된다
   public String doRetrieve(SearchVO inVO) throws SQLException {
      
      String jsonString = "";
      LOG.debug("=================================");
      LOG.debug("doRetrieve");
      LOG.debug("inVO : "+ inVO);
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

      //게시구분
      if(null == inVO.getDiv()) {
         inVO.setDiv(StringUtil.nvl(inVO.getDiv(), "10"));
      }
      
      LOG.debug("==============================");
      LOG.debug("inVO "+ inVO);
      LOG.debug("==============================");
      
      List<BoardVO> list = boardService.doRetrieve(inVO);
      Gson gson = new Gson();
      
      jsonString = gson.toJson(list);
      
      LOG.debug("==============================");
      LOG.debug("jsonString "+ jsonString);
      LOG.debug("==============================");
      
      return jsonString;
   }
   
   //board/board_list
   //board/board_reg
   //board/board_mod
   @RequestMapping(value="/boardView.do", method=RequestMethod.GET)
   public String boardView(Model model, SearchVO inVO) throws SQLException{
      LOG.debug("=================================");
      LOG.debug("boardView");
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

      //게시구분
      if(null == inVO.getDiv()) {
         inVO.setDiv(StringUtil.nvl(inVO.getDiv(), "10"));
      }      
      
      LOG.debug("==============================");
      LOG.debug("inVO "+ inVO);
      LOG.debug("==============================");   
      
      List<BoardVO> list = boardService.doRetrieve(inVO);
      
      int totalCnt = 0;//총글수
      double pageTotal = 0;//총 페이지(총글수/pageSize ? +1: 총글수/pageSize;)
      
      if(null != list && list.size() > 0) {
         totalCnt = list.get(0).getTotalCnt();//총글수
         
         pageTotal = Math.ceil(totalCnt/(inVO.getPageSize() * 1.0));
         LOG.debug("==============================");
         LOG.debug(": "+ (totalCnt/(inVO.getPageSize() * 1.0))); //1.2
         LOG.debug(": "+ Math.ceil(totalCnt/(inVO.getPageSize() * 1.0))); //2.0
         LOG.debug("pageTotal : "+pageTotal); 
         LOG.debug("==============================");   
      }
      
      model.addAttribute("totalCnt", totalCnt);
      model.addAttribute("pageTotal", pageTotal);
      model.addAttribute("list", list);
      model.addAttribute("vo", inVO);
      
      return "board/board_list";
   }

}