'use strict';

$(document).ready(function(){
	console.log('document.ready');
	
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
    
});