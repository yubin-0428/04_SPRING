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
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	
<title>Insert title here</title>

</head>
<body>
	<button class="change" type="button">테스트클릭</button>
	
	<script type="text/javascript">
	    $('.change').click(function() {
	    	var IMP = window.IMP;
	    	IMP.init('imp91452155');
	        // IMP.request_pay(param, callback) 결제창 호출
	        IMP.request_pay({ // param
	            pg: "html5_inicis",
	            pay_method: "card",
	            merchant_uid: 'merchant_'+new Date().getTime(),
	            name: "아메리카노",
	            amount: 2000,
	            buyer_email: "gildong@gmail.com",
	            buyer_name: "홍길동",
	            buyer_tel: "010-4242-4242",
	            buyer_addr: "서울특별시 강남구 신사동",
	            buyer_postcode: "01181"
	        }, function (rsp) { // callback
	        	console.log(rsp);
	            if (rsp.success) {
	              	var msg = '결제가 완료되었습니다.'
	              	msg += '결제 금액:'+rsp.paid_amount;
	                // 결제 성공 시 로직,
	            } else {
	            	var msg = '결제가 실패하였습니다.'
	                // 결제 실패 시 로직,
	            }
	            alert(msg);
	        });
	    });
    </script>
</body>
</html>