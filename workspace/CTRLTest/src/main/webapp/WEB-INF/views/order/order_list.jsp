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
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/main/main.css">
    <link rel="stylesheet" type="text/css" href="${CP_RES}/css/order/order_list.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/2974daa1cb.js"
                        crossorigin="anonymous"></script>
    <script type="text/javascript" src="${CP_RES}/js/login/login_popup.js"></script>

    <title>주문 조회 페이지</title>
    <script type="text/javascript">
        $(document).ready(function(){
        console.log("document.ready"); 
        
        // table click
        $('#listTable > tbody > tr').on("click", "input" ,function(){ 
            
            let clickInput = $(this); // $(this) : input
            let tdArray = clickInput.parents("tr").children(); // td들 지정
            
            // 각각 값을  가져오기
            let oNum = tdArray.eq(0).text(); // 주문 번호
            let dNum = tdArray.eq(5).text(); // 상세 번호
            let oName = tdArray.eq(6).text(); // 회원이름
            let pNum = tdArray.last().text(); // 상품번호
            
            window.open("${CP}/review/reviewPopup.do?oNum="+oNum+"&dNum="+dNum+"&oName="+oName+"&pNum="+pNum,"리뷰작성", "width=800, height=700, left=100, top=100");
            //--table click
        });
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
        <li class="info"><a href="${CP}/my_page.do">회원정보</a></li>
        <li class="order"><a href="${CP}/order/orderList.do"><strong>주문조회</strong></a></li>
    </ul>
</div>
<!-- ▲▲▲▲▲▲▲▲▲▲▲▲▲ 마이페이지  사각형 끝  ▲▲▲▲▲▲▲▲▲▲▲▲▲-->

  
  <table class="order2" width = "1000" height="50px">
      <tr>
         <th width="150"> 주문번호</th>
         <th width="130"></th>
         <th width="330">상품정보</th>
         <th width="150">금액</th>
         <th width="90">수량</th>
         <th width="150">진행상태</th>
         
         <!--  아래 세개는 리뷰 페이지를 위해 필요한 것  : 조회 필요-->
         <th width="100" style="display: none;">상세번호</th>
         <th width="100" style="display: none;">회원이름</th>
         <th width="100" style="display: none;">상품번호</th>
      </tr>
  </table>
      
      <table class="order3" id="listTable" width = "1000" height="100">
        <c:choose>
         <c:when test="${list.size() > 0}">
             <c:forEach var="list" items="${list}"> 
               <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                <tr>
                    <th width="150"  class="oNum"> ${list.oNum}</th>
                    <th width="130"><img src="${CP_RES}/img/${list.pNum}.jpg" alt="상품 이미지" width="90"/></th>
                    <th width="330"><a class="text">${list.pName}</a></th>
                    <th width="150">${list.pPrice}원</th>
                    <th width="90">${list.dBuy}개</th>
                    <th width="150">${list.oStatus}
                      <br><input type="button" value="리뷰 쓰기"/>
                    </th>
                    <th style="display: none;">${list.dNum}</th>
                    <th style="display: none;">${list.oName}</th>
                    <th style="display: none;">${list.pNum}</th>
                </tr>                                                           
            </c:forEach>
            </c:when>
                 <c:otherwise>
                    <tr><td colspan="99" class="text-center">주문하신 상품이 없습니다.</td></tr>
                </c:otherwise>
        </c:choose> 
        </tbody>
       </table>
       </div>
</body>
</html>