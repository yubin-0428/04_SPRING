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
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/productDetail/productDetail.css">
    
    <title>제품 상세 페이지</title>
    <!-- jQuery -->
    <script src="${CP_RES}/js/etc/jquery-1.12.4.js"></script>
    
    <!-- font awesome -->
    <script src="https://kit.fontawesome.com/2974daa1cb.js" crossorigin="anonymous"></script>
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
    
    <!-- 콘텐츠 영역 시작 -->
    <div id="contents">
      <!-- 상품 상세 콘텐츠 영역 첫번째 시작 (이미지, 이름, 가격, 버튼들)-->
        <div class="product_contents">
          <img alt="상품 이미지" src="${CP_RES}/img/${productInfo.pNum}.jpg">
            
          <div class="info">
            <form action="#" method="get">
            
                <!-- 상품 이름, 용량, 가격 -->
                <strong class="product_name">${productInfo.pName}</strong><br/>
                <hr/>
                <p class="product_price">${productInfo.pPrice}</p>
            
	            <!-- 수량 -->
	            <div id="amount">
	              <div id="buy_number">0</div>
	                    <div class="number_buttons">
	                        <input type="button" id="plus" name="plus" value="+"/>              
	                        <input type="button" id="minus" name="minus" value="-"/>
	                    </div>
	            </div>
	            <!--// 수량 -->
	            
	            <!-- 총금액 -->  
	            <p class="total_price">Total price : </p>
	            <div id="total_num">0</div><br/>
	            
	            <div class="submit_buttons">
	                 <input class="btn-2 button" type="submit" value="CART">
	                 <input class="btn-1 button" type="submit" value="BUY">          
	            </div>            
            </form>
          </div> <!-- .info -->
        </div> <!-- .product_contents -->
      <!-- 상품 상세 콘텐츠 영역 첫번째 끝 (이미지, 이름, 가격, 버튼들)-->  
    <hr />
    
    <!-- 아코디언 메뉴(상세설명, 리뷰) -->
    <div id="Accord_container">
        <div id="Accordion_wrap">
           <div class="accord_title">
            <span>제품 정보</span>
           </div>
           <div class="contents info_contents">
                        상품 이름 : <span>${productInfo.pName}</span>
             <br/><br/>
                        용량 : <span>${productInfo.pSize}</span></br/>
                        가격 : <span class="detail_price">${productInfo.pPrice}</span>
           </div>
            <div class="accord_title">
            <span>고객 리뷰</span>
           </div>
           <div class="contents review_contents">
            <span>This is second answer.</span>
           </div>
        </div>
    </div>
    <!--// 아코디언 메뉴(상세설명, 리뷰) -->
    </div> 
    <!-- 콘텐츠 영역 끝 -->
    <script type="text/javascript" src="${CP_RES }/js/productDetail/productDetail.js"></script>
    </body>
</html> 
    