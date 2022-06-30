<%--
/**
	Class Name:
	Description:
	Modification information
	
	수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 21.        최초작성 
    
    author Ctrl 개발팀
    since 2020.11.23
    Copyright (C) by KandJang All right reserved.
*/
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">
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
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
    <script src="${CP_RES }/js/payco/payco.js"></script>
     <!-- css -->
    <link href="${CP_RES}/css/pay/before.css" rel="stylesheet">
    
    <title>결제 전</title>
    
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
<!-- 배송지 -->
    <div class="address">
        <h1 class="title">배송지<input class="change" type="button" value="변경" src="#"></h1>
            <input  class="Home" type="text" value="마포구 서강로 136 아이비타워 2층">
        <h1 class="title">주문자</h1>
            <p class="name">이름<input class="orderer" type="text" value="김태민"></p>
            <p class="name">전화번호<input class="tel" type="tel" value="010-1234-5678"></p>
        <h1 class="title">주문상품</h1>
            <input class="img" type="image" src="${CP_RES}/img/bowls01.jpg" align="left" align="middle">
            <p class="img1"><p>메트로시크 샐러드볼</p>\242,000원<p>1개</p>
    </div>
        <div class="payment">
            <h1 class="title">결제금액</h1>
            <h1 class="pay1">총 상품 금액</h1>
            <a href="#"><p class="pay2">\242,000원</p></a>
            <h1 class="pay1">배송비</h1>
            <a href="#"><p class="pay2">무료</p></a>
            <h1 class="pay1">최종 결제 금액</h1>
            <a href="#"><p class="pay2">\242,000원</p></a>
            <p><input class="check" type="checkbox" checked>아래 내용에 모두 동의합니다.(필수)</p>
            <p class="pay3">“쇼핑몰”은 이용자의 개인정보 수집시 서비스 제공을 위하여 필요한 범위에서 최소한의 개인정보를 수집합니다.
            “쇼핑몰”은 회원가입시 구매계약이행에 필요한 정보를 미리 수집하지 않습니다. 다만, 관련 법령상 의무이행을 위하여 구매계약 이전에 본인확인이 필요한 경우로서 최소한의 특정 개인정보를 수집하는 경우에는 그러하지 아니합니다.
            “쇼핑몰”은 이용자의 개인정보를 수집•이용하는 때에는 당해 이용자에게 그 목적을 고지하고 동의를 받습니다.
            “쇼핑몰”은 수집된 개인정보를 목적 외의 용도로 이용할 수 없으며, 새로운 이용목적이 발생한 경우 또는 제3자에게 제공하는 경우에는 이용•제공단계에서 당해 이용자에게 그 목적을 고지하고 동의를 받습니다. 다만, 관련 법령에 달리 정함이 있는 경우에는 예외로 합니다
            “쇼핑몰”이 제2항과 제3항에 의해 이용자의 동의를 받아야 하는 경우에는 개인정보 관리보호 책임자의 신원(소속, 성명 및 전화번호, 기타 연락처), 정보의 수집 목적 및 이용목적, 제3자에 대한 정보제공 관련사항(제공 받는 자, 제공목적 및 제공할 정보의 내용)등 정보 통신망 이용 촉진 등에 관한 법률 제16조 제3항이 규정한 사항을 미리 명시하거나 고지해야 하며 이용자는 언제든지 이 동의를 철회할 수 있다.
            이용자는 언제든지 “쇼핑몰”이 가지고 있는 자신의 개인정보에 대해 열람 및 오류정정을 요구할 수 있으며 “쇼핑몰”은 이에 대해 지체 없이 필요한 조치를 취할 의무를 진다. 이용자가 오류의 정정을 요구한 경우에는 “쇼핑몰”은 그 오류를 정정할 때까지 당해 개인 정보를 이용하지 않는다.
            “쇼핑몰”은 개인정보 보호를 위하여 이용자의 개인정보를 처리하는 자를 최소한으로 제한하여야 하며 신용카드, 은행계좌 등을 포함한 이용자의 개인정보의 분실, 도난, 유출, 동의 없는 제3자 제공, 변조 등으로 인한 이용자의 손해에 대하여 모든 책임을 집니다.
            “쇼핑몰” 또는 그로부터 개인정보를 제공받은 제3자는 개인정보의 수집목적 또는 제공받은 목적을 달성한 때에는 당해 개인정보를 지체 없이 파기한다.
            “쇼핑몰”은 개인정보의 수집•이용•제공에 관한 동의란을 미리 선택한 것으로 설정해두지 않습니다. 또한 개인정보의 수집•이용•제공에 관한 이용자의 동의거절시 제한되는 서비스를 구체적으로 명시하고, 필수수집항목이 아닌 개인정보의 수집•이용•제공에 관한 이용자의 동의 거절을 이유로 회원가입 등 서비스 제공을 제한하거나 거절하지 않습니다.</p>
            <input class="change" type="button" value="결제">
        </div>
</body>
</html>