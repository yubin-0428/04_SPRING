<%--
/**
    Class Name:
    Description:
    Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 21.   최초작성 
    
    author CTRL 개발팀
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
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/ctrl.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/detail.css">
    
    <title>마이페이지</title>
    <!-- jQuery -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${CP_RES}/js/detail.js"></script>
</head>
<body>
<%@ include file = "../menu/member_menu.jsp" %>
<h2>마이페이지</h2>
<table border="1" >
    <tr>
        <td>번호</td>
        <td>아이디</td>
        <td>비밀번호</td>
        <td>이메일</td>
        <td>핸드폰번호</td>
    </tr>
    
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.mNum }</td>
        <td>${row.mId }</td>
        <td>${row.mPw }</td>
        <td>${row.mMail }</td>
        <td>${row.mPhone }</td>
    </tr>
    </c:forEach>
</table>
<input type="button" value="메인으로" class="btn" onclick="location.href={CP}/member/memberMenu.do">
</body>
</html>