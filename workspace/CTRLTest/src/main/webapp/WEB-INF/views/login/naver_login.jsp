<%--
/**
        Class Name:
        Description:
        Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 23.        최초작성 
    
    author ehr 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 네이버api -->
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources" />
<c:set var="CP_RES" value="${CP}${resources}" />


<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="${CP_RES}/css/login/login_style.css">

<title>네이버 로그인</title>
</head>
<body>
	<div class="container">
		<h1>LOGIN</h1>
		<div class="login_area">
			<div id="message">
				저희 테이블웨어에 오신걸 환영합니다.</br> 로그인 후 다양한 서비스를 이용해주세요.</br> 즐거운 시간되세요.
			</div>
			<div id="button_area">
				<div id="naverIdLogin"></div>
			</div>
		</div>
	
	<%
		String clientId = "SFHYYlRp9uGKqdsmMrqu";//애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8081/ctrl/login/callback.do", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		session.setAttribute("state", state);
	%>
	<a href="<%=apiURL%>"><img height="60"
		src="${CP_RES}/img/naver_btnG_완성형.png" /></a>
    </div>		
</body>
</html>