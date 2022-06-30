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
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/main/main.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/my_page/my_page.css">
    
    <title>마이페이지</title>
    <!-- jQuery -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${CP_RES}/js/detail.js"></script>
</head>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/2974daa1cb.js"
    crossorigin="anonymous"></script>
<script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>


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
                    <li>로그아웃</li>



                    <li><a href="#">마이페이지</a></li>
                    <li><a href="#">장바구니</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">공지사항</a></li>
                </ul>
                <form action="#" method="post" id="search" name="search">
                    <input type="text" />
                    <button>
                        <i class="fas fa-search fa-lg"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>

    <!-- 메인 헤더 영역 끝 -->



<!-- 마이페이지 시작 -->
<div id="contents">
<!-- ▼▼▼▼▼▼▼▼▼▼▼▼▼ 마이페이지  사각형  ▼▼▼▼▼▼▼▼▼▼▼▼▼ -->
<title>my_page</title>

<div class="my_box">
    <ul>
        <li class="my"><strong>마이페이지</strong><li>
        <li class="info"><a href="${CP}/my_page.do"><strong>회원정보</strong></a></li>
        <li class="order"><a href="${CP}/order/orderList.do">주문조회</a></li>
    </ul>
</div>
<!-- ▲▲▲▲▲▲▲▲▲▲▲▲▲ 마이페이지  사각형 끝  ▲▲▲▲▲▲▲▲▲▲▲▲▲-->  

<!-- ▼▼▼▼▼▼▼▼▼▼▼▼▼ 마이페이지  회원정보  ▼▼▼▼▼▼▼▼▼▼▼▼▼ --> 
<div id="my_all">
<img src="${CP_RES}/img/photo2.jpg" alt="프로필 사진" class="ryan" width="230" height="230">

<!-- 이름, 이메일 테이블 -->
<table class="blueone" border="0" width="640" height="20">
    
    <tr>
        <th> ♥ 이름 ♥</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.mName }</td>
    </tr>
    </c:forEach>
    
     <tr>
        <th>♥ 이메일 ♥</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.mEmail }</td>
    </tr>
    </c:forEach>
    
</table> 
<!-- // 이름, 이메일 테이블 -->

<!-- 번호, 주소 테이블 -->
<table class="blueone2" border="0" width="900" height="20">     
   
    
    <tr>
        <th>♥ 핸드폰 번호 ♥</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.mTel }</td>
    </tr>
    </c:forEach>
    
    <tr>
        <th>♥ 주소 ♥</th>
    </tr>
    <c:forEach var="row" items="${list}">
    <tr>
        <td>${row.mAddr }</td>
    </tr>
    </c:forEach>
    
  </table>
        <!-- // 번호, 주소 테이블 -->
        <div class="solo"  style="border:1px solid #ddd; padding:5px;">개인정보처리자는 개인정보를 수집하는 경우에는 그 목적에 필요한 최소한의 개인정보를 수집해야 합니다. 이 경우 최소한의 개인정보 수집이라는 입증책임은 개인정보처리자가 부담합니다(「개인정보 보호법」 제16조제1항)</div>
    </div>
</div>
</body>
</html>