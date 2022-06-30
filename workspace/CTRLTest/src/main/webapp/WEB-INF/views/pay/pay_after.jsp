<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 21.   최초작성 
    
    author Ctrl 개발팀
    since 2020.11.23
    Copyright (C) by KandJang All right reserved.
*/
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="CP" value="${pageContext.request.contextPath}"/>
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES" value="${CP}${resources}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- css -->
    <link href="${CP_RES}/css/pay/after.css" rel="stylesheet">
    
    <title>결제 후</title>
    
     <!-- font awesome -->
	<script src="https://kit.fontawesome.com/2974daa1cb.js" crossorigin="anonymous"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        console.log("document.ready"); 
      });
    </script>
    
</head>
<body>
	 <!-- 메인 헤더 영역 시작 -->
 <div id="header">
    <div id="top">
        <div id="logo">
            <a href="#"><img src="${CP_RES}/img/tableware_logo.png" alt="로고이미지"></a>
        </div>
        <div class="menu_left">
            <ul>
            <li><a href="#">접시</a></li>
            <li><a href="#">머그컵</a></li>
            <li><a href="#">유리잔</a></li>
            <li><a href="#">보울/면기</a></li>
            </ul>
        </div>
        <div class="menu_right">
            <ul>
            <li><a href="#">로그인</a></li>
            <li><a href="#">마이페이지</a></li>
            <li><a href="#">장바구니</a></li>
            <li><a href="#">FAQ</a></li>
            <li><a href="#">공지사항</a></li>
            </ul>
            <form action="#" method="post" id="search" name="search">
                <input type="text"/>
                <button>
                    <i class="fas fa-search fa-lg"></i>
                </button>
            </form>
        </div> 
    </div>
</div>
<!-- 메인 헤더 영역 끝 -->

<!-- 결제 후 -->
<div class="title">
    <h1>결제가 완료 되었습니다.</h1>
</div>
<div class="subtitle">
    <h4>저희 쇼핑몰을 이용해 주셔서 감사합니다.</h4>
</div>
<div class="main">
    <input class="btn" type="button" value="쇼핑 계속 하기" src="#">
</div>
</body>
</html>