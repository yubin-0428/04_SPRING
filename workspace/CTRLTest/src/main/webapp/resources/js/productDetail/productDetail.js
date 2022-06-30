'use strict';

$(document).ready(function(){
	
   // 가격에 콤마 붙이는 함수
   function priceToString(price) {
	   console.log(price);
	   return price.replace(/\B(?=(\d{3})+(?!\d))/g, ',');
   }
   
   let price =$(".product_price").text();
   $(".product_price").text(priceToString(price)+"원");
   $(".detail_price").text(priceToString(price)+"원");
   
    
   // 아코디언 메뉴
  $(".accord_title").click(function() {
    $(this).next(".contents").stop().slideToggle(300);
    $(this).toggleClass('on').siblings().removeClass('on');
    $(this).next(".contents").siblings(".contents").slideUp(300); // 1개씩 펼치기
  });

  
  $("#plus").on("click", function(e){
	  count('plus');
  });

  $("#minus").on("click", function(e){
	  count('minus');
  });
  
  /* 구매 수량 증가&감소 함수 - 수량과 total price가 같이 증가&감소 */ 
  function count(type)  { 
	  // 현재 화면에 표시된 값
	  let bNumber = $("#buy_number").text(); // 구매 수량
	  let productPrice = $(".product_price").text(); // 상품 금액
	  let minusComma = productPrice.replace(",", ""); // 상품금액에서 , 제거
	  let priceNumber = minusComma.substring(0, minusComma.indexOf("원"));
	  console.log("priceNumber : " + priceNumber);
	  // 더하기/빼기
	  if(type === "plus") {
		  if(bNumber < 999) {
			  $("#buy_number").text(parseInt(bNumber) + 1);
			  bNumber = parseInt(bNumber) + 1;  
		  }
		  
		  
	  }else if(type === "minus")  {
		  if(bNumber == 1) {
			  $("#buy_number").text('1');
			  return;
		  }
		  
		  $("#buy_number").text(parseInt(bNumber) - 1);
		  bNumber = parseInt(bNumber) - 1;
	  }
	  let totalNum = (bNumber * priceNumber) + "";
	  console.log("totalNum 후");
	  
	  // 총 금액 변경 
	  $("#total_num").text(priceToString(totalNum)+"원");
  }
  
});

