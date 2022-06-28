<%--
/**
	Class Name:tmp_menu.jsp
	Description: 임시메뉴
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
    
    <title>부트 스트랩-boot_list</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
        
    <script type="text/javascript">
      $(document).ready(function(){
    	console.log("document.ready");  
    	  
      });
      
      
    </script>
</head>
<body>
       <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>임시메뉴</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
          <!-- tabble -->
          <div class="table-responsive">
           <table class="table table-striped table-bordered table-hover table-condensed">
               <thead class="bg-primary">
                 <tr>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">번호</th>
                     <th class="text-center col-sm-10 col-md-10 col-lg-10">메뉴</th>
                 </tr>
               </thead>
               <tbody>
                <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">1</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/boot/bootList.do">목록</a></td>
                 </tr>              
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">2</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/boot/bootReg.do">등록</a></td>
                 </tr>  
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">3</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/user/userView.do">회원관리</a></td>
                 </tr>                
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">4</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/login/loginView.do">로그인</a></td>
                 </tr> 
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">5</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/board/boardView.do?div=10">공지사항</a></td>
                 </tr>
                 <tr>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">6</td>
                     <td class="text-left   col-sm-10 col-md-10 col-lg-10"><a href="${CP }/board/boardView.do?div=20">자유게시판</a></td>
                 </tr>                                                                                                           
               </tbody>
           </table>
          </div>
          <!--// tabble ----------------------------------------------------------->

          
       </div>
       <!--// div container --------------------------------------------------->
</body>
</html>