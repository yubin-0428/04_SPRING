<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 20.        최초작성 
    
    author ehr 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES"    value="${CP}${resources}" />
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">
    <title>회원관리-boot_list</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <style type="text/css">
      /* page-loading */
	  #loading {
	    width: 100%;
	    height: 100%;
	    top: 0;
	    left: 0;
	    position: fixed;
	    display: block;
	    opacity: 0.6;
	    background: #e4e4e4;
	    z-index: 99;
	    text-align: center;
	  }
	
	
	
	  #loading > img {
	    position: absolute;
	    top: 50%;
	    left: 50%;
	    z-index: 100;
	  }
	   #loading > p {
	        position: absolute;
	        top: 57%;
	        left: 43%;
	        z-index: 101;
	    }
	    
    </style>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <!-- 사용자 정의 function, ISEmpty -->
    <script src="${CP_RES}/js/eUtil.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES}/js/eclass.js"></script>
    
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
    <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/jquery.bootpag.js"></script>
        
    <script type="text/javascript">
      //--$(document).ready
      $(document).ready(function(){
    	  
    	  //프로그래스 하이드
    	  $("#loading").hide();
    	  console.log("document.ready");  
    	  
    	  //
    	  renderingPage('${pageTotal}',1);
    	  
    	  //paging
    	  //pageTotal: 총페이지수,
    	  //page: 현재 페이지
    	  function renderingPage(pageTotal,page){
    		  console.log("pageTotal:"+pageTotal);
    		  console.log("page:"+page);
    		  
    		  //pageTotal을 int로 변환
    		  pageTotal = parseInt(pageTotal);
    		  
    		  //이전 연결된 EventHandler제거
    		  $('#page-selection').unbind('page');
    		  
    		  $('#page-selection').bootpag({
    			    total: pageTotal, 
    			    page: page,
    			    maxVisible: 10,
    			    leaps: true,
    			    firstLastUse: true,
    			    first: '←',
    			    last: '→',
    			    wrapClass: 'pagination',
    			    activeClass: 'active',
    			    disabledClass: 'disabled',
    			    nextClass: 'next',
    			    prevClass: 'prev',
    			    lastClass: 'last',
    			    firstClass: 'first'
    			}).on("page", function(event, num){
    			    console.log("num:"+num);
    			    doRetrieve(num);
    			});     		  
    		  
    	  }
    	  
    	  //id중복 Check: 등록일 경우만 동작
    	  $("#idCheck").on("click",function(){
    		  console.log("idCheck");
    		  if(eUtil.ISEmpty($("#uId").val())){
                  alert("아이디를 입력하세요.");
                  $("#uId").focus();
                  return;
              }
    		
    		  
    		  let url = "${CP}/user/idCheck.do";
              let method ="GET";
              let async  = true;
              
              let parameters = {
                      "uId": $("#uId").val()  
              };
              
              EClass.callAjax(url, parameters, method, async, function(data) {
            	  console.log('data:'+data);
            	  //alert(data.msgContents); 
            	  if("1" == data.msgId){//id중복
            		  alert(data.msgContents); 
            	      //사용할수 없음
            	      $("#idCheckYN").val("0");
            		  
            	  }else{//id사용 가능
            		  alert(data.msgContents); 
                      //사용할수 있음
                      $("#idCheckYN").val("1");            		  
            	  }
            	  
            	  
              });
              
    	  });
    	  
    	  
    	  //숫자만 입력
    	  //속성
    	  // $("input:text[numberOnly]").on("keyup",function(e){
    	  //	  console.log("$(this).val():"+$(this).val());  
    	  //});
    	  
    	  $(".numberOnly").on("keyup",function(e){
    		  console.log("$(this).val():"+$(this).val());
    		  
    		  $(this).val(   $(this).val().replace(/[^0-9]/g, "")     );
    	  });
    	  
    	  
    	  //검색어 Enter
    	  $("#searchWord").on("keypress",function(e){
    		  console.log("searchWord"+e.which);  
    		  if(13==e.which){
    			  e.preventDefault();
    			  doRetrieve(1);
    		  }
    		  
    	  });
    	  
    	  //등록
    	  $("#add").on("click",function(){
    		  console.log("add");  
    		  if(eUtil.ISEmpty($("#uId").val())){
                  alert("아이디를 입력하세요.");
                  $("#uId").focus();
                  return;                 
              }
              
              if(eUtil.ISEmpty($("#name").val())){
                  alert("이름을 입력하세요.");
                  $("#name").focus();
                  return;                 
              }           
              
              if(eUtil.ISEmpty($("#passwd").val())){
                  alert("비번을 입력하세요.");
                  $("#passwd").focus();
                  return;                 
              }
              
              if(eUtil.ISEmpty($("#login").val())){
                  alert("로그인 회수을 입력하세요.");
                  $("#login").focus();
                  return;                 
              }  
              
              
              if(eUtil.ISEmpty($("#recommend").val())){
                  alert("추천 수을 입력하세요.");
                  $("#recommend").focus();
                  return;                 
              }    
              
              if(eUtil.ISEmpty($("#email").val())){
                  alert("이메일 입력하세요.");
                  $("#email").focus();
                  return;                 
              }               
              
              
              if(confirm("등록 하시겠습니까?")==false )return;    	
              
              let url = "${CP}/user/add.do";
              let method = "POST";
              let parameters = {
                      "uId": $("#uId").val(),
                      "name": $("#name").val(),
                      "passwd": $("#passwd").val(),
                      "intLevel": $("#intLevel").val(),
                      "login": $("#login").val(),
                      "recommend": $("#recommend").val(),
                      "email": $("#email").val()
              };
              let async;
              EClass.callAjax(url,parameters,method,async,function(data){
                  console.log("data.msgId:"+data.msgId);
                  console.log("data.msgContents:"+data.msgContents);
                  if("1"==data.msgId){//수정 성공
                      alert(data.msgContents);
                      //목록조회
                      //trigger통한 호출
                      //$( "#doRetrieve" ).trigger( "click" );
                      doRetrieve(1);
                      //하단 초기화
                      init();
                      
                  }else{
                      alert(data.msgContents);
                  }            	  
            	  
              });
              
    	  });
    	  
    	  //목록 검색 함수
    	  function doRetrieve(page){
    		  console.log("doRetrieve");  
              let url = "${CP}/user/doRetrieve.do";
              let method = "GET";
              let async  = true;
              let parameters = {
                      searchDiv: $("#searchDiv").val(),
                      searchWord:$("#searchWord").val(),
                      pageSize:$("#pageSize").val(),
                      pageNum:page
              };
              
              EClass.callAjax(url,parameters,method,async,function(data){
                  console.log("EClass.callAjax data:"+data);
                  
                  let parsedData = data;
                  //1.
                  $("#user_table>tbody").empty();                 
                  
                  let htmlData="";
                  
                  let totalCnt  = 0; //총글수
                  let pageTotal = 1; //페이지수
                  
                  //데이터가 있는 경우
                  if(null != parsedData && parsedData.length>0){
                	  
                	  totalCnt = parsedData[0].totalCnt
                	  console.log('totalCnt:'+totalCnt);
                	                    
                	  pageTotal = totalCnt/$("#pageSize").val();
                	  console.log('pageTotal:'+pageTotal);
                	  pageTotal = Math.ceil(pageTotal);
                	  console.log('pageTotal:'+pageTotal);
                	  
                	  
                      $.each(parsedData, function(index,value) {
                          console.log(index+","+value.name);
                          htmlData += "<tr>                                                                     ";
                          htmlData += "    <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num+"</td>";
                          htmlData += "    <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.uId+"</td>";
                          htmlData += "    <td class='text-left   col-sm-2 col-md-2 col-lg-2'>"+value.name+"</td>";
                          htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.level+"</td>";
                          htmlData += "    <td class='text-left   col-sm-3 col-md-3 col-lg-3'>"+value.email+"</td>";
                          htmlData += "    <td class='text-center col-sm-2 col-md-2 col-lg-2'>"+value.regDt+"</td>";
                          htmlData += "</tr>                                                                    ";                            
                      });
                      
                  //데이터가 없는 경우    
                  }else{
                          htmlData += " <tr><td colspan='99' class='text-center'>No data found</td></tr>" ;                           
                  }
                  //2.
                  $("#user_table>tbody").append(htmlData);
                  
                  //paging
                  //기존 페이징 지우기
                  $("#page-selection").empty();
                  
                  //paging호출
                  renderingPage(pageTotal, page);
                  
                  //관리 데이터 초기화
                  init();
                  
                  
                  
                  
              });
            
           //--doRetrieve    		  
    	  }
    	  
    	  //수정
    	  $("#doUpdate").on("click",function(){
    		  console.log('doUpdate');
    		  
    		  console.log("eUtil.ISEmpty:"+eUtil.ISEmpty($("#uId").val()));
    		  
    		  if(eUtil.ISEmpty($("#uId").val())){
    			  alert("아이디를 입력하세요.");
                  $("#uId").focus();
                  return;    			  
    		  }
    		  
              if(eUtil.ISEmpty($("#name").val())){
                  alert("이름을 입력하세요.");
                  $("#name").focus();
                  return;                 
              }    		  
    		  
              if(eUtil.ISEmpty($("#passwd").val())){
                  alert("비번을 입력하세요.");
                  $("#passwd").focus();
                  return;                 
              }
              
              if(eUtil.ISEmpty($("#login").val())){
                  alert("로그인 회수을 입력하세요.");
                  $("#login").focus();
                  return;                 
              }  
              
              
              if(eUtil.ISEmpty($("#recommend").val())){
                  alert("추천 수을 입력하세요.");
                  $("#recommend").focus();
                  return;                 
              }    
              
              if(eUtil.ISEmpty($("#email").val())){
                  alert("이메일 입력하세요.");
                  $("#email").focus();
                  return;                 
              }               
              
              
              if(confirm("수정 하시겠습니까?")==false )return;
              
              let url = "${CP}/user/doUpdate.do";
              let parameters = {
            		  "uId": $("#uId").val(),
            		  "name": $("#name").val(),
            		  "passwd": $("#passwd").val(),
            		  "intLevel": $("#intLevel").val(),
            		  "login": $("#login").val(),
            		  "recommend": $("#recommend").val(),
            		  "email": $("#email").val()
              };
              
              let method = "POST";
              let async  = true;
              
              EClass.callAjax(url, parameters, method, async, function(data) {
            	  console.log("data.msgId:"+data.msgId);
            	  console.log("data.msgContents:"+data.msgContents);
            	  if("1"==data.msgId){//수정 성공
            		  alert(data.msgContents);
            		  //목록조회
            		  //trigger통한 호출
            		  //$( "#doRetrieve" ).trigger( "click" );
            		  doRetrieve(1);
            		  //하단 초기화
            		  init();
            		  
            	  }else{
            		  alert(data.msgContents);
            	  }
              });
              
    	  //--수정	  
    	  });
    	  
    	  //삭제
    	  $("#doDelete").on("click", function(){
    		    console.log("doDelete");
    		    
    		    let url = "${CP}/user/doDelete.do";
    		    
    		    if(eUtil.ISEmpty($("#uId").val())){
    		    	alert("아이디를 입력하세요.");
    		    	$("#uId").focus();
    		    	return;
    		    }
    		    
    		    let parameters = {
    		    		"uId": $("#uId").val()	
    		    };
    		    
    		    let method ="GET";
    		    let async  = true;
    		    
    		    if(confirm("삭제 하시겠습니까?")==false)return;
    		    EClass.callAjax(url, parameters, method, async, function(data) {
    		    	console.log('data:'+data);  
    		    	
    		    	if("1"==data.msgId){
    		    		alert(data.msgContents);
    		    		//1. 목록조회
    		    		doRetrieve(1);
    		    		//2. 관리초기화
    		    		init();
    		    	}else{
    		    		alert(data.msgContents);
    		    	}
    		    	
    		    	
    		    	
    		    });
    	  //--삭제	  
    	  });
    	  
    	  //관리초기화: 하단 데이터 ""으로 초기화
    	  function init(){
              const initValue = "";
              
              $("#idCheckYN").val(initValue);
              
              $("#uId").val(initValue);
              $("#name").val(initValue);
              $("#passwd").val(initValue);
              $("#intLevel").val(1);
              $("#login").val(initValue);
              $("#recommend").val(initValue);
              $("#email").val(initValue);
              $("#regDt").val(initValue);    		  
    	  }
    	  
    	  
    	  //초기화
    	  $("#initBtn").on("click",function(){
    		  
    		  console.log("initBtn");
    		  init(); 
    		  //disabled 비활성화
    		  $("#uId").prop("disabled",false);
    	  //--초기화 	  
    	  });
    	  
    	  //table click
    	  $("#user_table>tbody").on("click","tr",function(e){
    		  
    		  console.log('user_table>tbody>tr');
    		  let tds = $(this).children();
    		  let uId = tds.eq(1).text();
    		  console.log('uId:'+uId);
    		  
    		  let url = "${CP}/user/doSelectOne.do";
    		  let method = "GET";
    		  let async  = true;
    		  let parameters = { "uId":uId };
    		  
    		  EClass.callAjax(url, parameters,method, async,function(data){
    			  console.log("data:"+data);
    			  console.log("data.name:"+data.name);
    			  console.log("data.intLevel:"+data.intLevel);
    				
    			  $("#uId").val(data.uId);	 
    			  $("#name").val(data.name);
    			  $("#passwd").val(data.passwd);
    			  $("#intLevel").val(data.intLevel);
    			  $("#login").val(data.login);
    			  $("#recommend").val(data.recommend);
    			  $("#email").val(data.email);
    			  $("#regDt").val(data.regDt);
    			  
    			  //사용하지 못함으로 처리
    			  $("#uId").prop("disabled","disabled");
    			  
    		  });
    		  
    		  
    	  //--table click	  
    	  });
    	  
    	  
    	  //doRetrieve
    	  $("#doRetrieve").on("click",function(e){
    		    console.log("doRetrieve");  
                doRetrieve(1);
    		  
          //--doRetrieve		  
    	  });
    	
    
      //--$(document).ready 	  
      });
     
      
    </script>
</head>
<body>
       <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>회원관리</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
          
          <!-- 검색영역 -->
          <div class="row">
            <form action="#" class="form-inline col-sm-12 col-md-12 col-lg-12 text-right">
               <div class="form-group">
                 <select class="form-control  input-sm" name="searchDiv" id="searchDiv">
                    <option value="">전체</option>
                    <option value="10">아이디</option>
                    <option value="20">이름</option>
                    <option value="30">이메일</option>
                 </select>
                 <input type="text" class="form-control  input-sm"  placeholder="검색어"  
                     name="searchWord" id="searchWord"/>
                 <select class="form-control  input-sm" name="pageSize" id="pageSize">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                 </select>  
               <input type="button" id="doRetrieve" class="btn btn-primary btn-sm" value="목록"  />                           
               </div>
            </form>
          </div>
          <!--// 검색영역 ----------------------------------------------------------->
          
          <!-- table -->
          <div class="table-responsive">
           <table id="user_table" class="table table-striped table-bordered table-hover table-condensed">
               <thead class="bg-primary">
                 <tr>
                     <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">아이디</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">이름</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">등급</th>
                     <th class="text-center col-sm-3 col-md-3 col-lg-3">이메일</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">등록일</th>
                 </tr>
               </thead>
               <tbody>
                 <c:choose>
                    <c:when test="${list.size()>0 }">
                     <c:forEach var="vo" items="${list }">
	                     <tr>  
	                         <td class="text-center col-sm-1 col-md-1 col-lg-1">${vo.num }</td>
	                         <td class="text-left   col-sm-2 col-md-2 col-lg-2">${vo.uId }</td>
	                         <td class="text-left   col-sm-2 col-md-2 col-lg-2">${vo.name }</td>
	                         <td class="text-center col-sm-2 col-md-2 col-lg-2">${vo.level }</td>
	                         <td class="text-left   col-sm-3 col-md-3 col-lg-3">${vo.email }</td>
	                         <td class="text-center col-sm-2 col-md-2 col-lg-2">${vo.regDt }</td>
	                     </tr>
                     </c:forEach>                    
                    </c:when>   
                    <c:otherwise>
                        <tr><td colspan="99" class="text-center">No data found</td></tr>
                    </c:otherwise>
                 </c:choose>              
                                                          
               </tbody>
           </table>
          </div>
          <!--// tabble ----------------------------------------------------------->
	        <!-- pagenation -->
	        <div  class="text-center col-sm-12 col-md-12 col-lg-12">
	            <div id="page-selection" class="text-center page"></div>
	        </div>        
	        <!--//pagenation ------------------------------------------------------>
            
       </div>
       <div class="spinner"></div>
       
		<!--로딩바-->
		<div id='loading' style='margin-left: 0px;'>
		    <img src='${CP_RES}/imgs/loading_bar.gif'>
		    <p>잠시기다려주세요.</p>
		</div>
       
       <!--// div container --------------------------------------------------->
       <!-- div container -->
       <div class="container">
          <!-- 버튼 -->
          <div class="row text-right">
             <label class="col-sm-3 col-md-2 col-lg-2"></label>
             <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="button" class="btn btn-primary btn-sm" value="초기화" id="initBtn" />
               <input type="button" class="btn btn-primary btn-sm" value="등록"  id="add"/>
               <input type="button" class="btn btn-primary btn-sm" value="삭제"  id="doDelete" />
               <input type="button" class="btn btn-primary btn-sm" value="수정"  id="doUpdate"/>
             </div>
          </div>
          <!--// 버튼 ------------------------------------------------------------->
          <!-- form -->
          <form action="" class="form-horizontal">
             <input type="hidden" name="idCheckYN" id="idCheckYN">
             <div class="form-group">
                  <label for="uId" class="col-sm-3 col-md-2 col-lg-2 control-label">아이디</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="20" name="uId" id="uId" placeholder="아이디" class="form-control">
                    <input type="button" class="btn btn-primary btn-sm form-control" value="중복확인"  id="idCheck"/>
                  </div>
             </div>
             <div class="form-group">
                  <label for="name" class="col-sm-3 col-md-2 col-lg-2 control-label">이름</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="20" name="name" id="name" placeholder="이름" class="form-control">
                  </div>
             </div>
             <div class="form-group">
                  <label for="passwd" class="col-sm-3 col-md-2 col-lg-2 control-label">비번</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="password" maxlength="20" name="passwd" id="passwd" placeholder="비번" class="form-control">
                  </div>
             </div>
             <div class="form-group">
                  <label for="intLevel" class="col-sm-3 col-md-2 col-lg-2 control-label">등급</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <select name="intLevel" id="intLevel" class="form-control">
                      <option value="1">BASIC</option>
                      <option value="2">SILVER</option>
                      <option value="3">GOLD</option>
                    </select>
                  </div>
             </div>
             <div class="form-group">
                  <label for="login" class="col-sm-3 col-md-2 col-lg-2 control-label">로그인</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="8"  name="login" id="login" placeholder="로그인" class="numberOnly form-control">
                  </div>
             </div>
             <div class="form-group">
                  <label for="recommend" class="col-sm-3 col-md-2 col-lg-2 control-label">추천</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="8" name="recommend" id="recommend" placeholder="추천" class="numberOnly form-control">
                  </div>
             </div>                                       
             <div class="form-group">
                  <label for="email" class="col-sm-3 col-md-2 col-lg-2 control-label">이메일</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="320" name="email" id="email" placeholder="이메일" class="form-control">
                  </div>
             </div>  
             <div class="form-group">
                  <label for="email" class="col-sm-3 col-md-2 col-lg-2 control-label">등록일</label>
                  <div class="col-sm-9 col-md-10 col-lg-10">
                    <input type="text" maxlength="320" name="regDt" id="regDt" placeholder="등록일" class="form-control" readonly="readonly">
                  </div>
             </div>
                                       
          </form>
          <!--// form ---------------------------------------------------------->             
                              
       
       </div>
       <!--// div container --------------------------------------------------->       
    
</body>
</html>