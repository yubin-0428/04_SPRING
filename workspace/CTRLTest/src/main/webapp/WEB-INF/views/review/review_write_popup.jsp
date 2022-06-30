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
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${CP_RES }/css/review/review_write_popup.css">
    <title>상품 리뷰</title>
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/etc/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/etc/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/etc/eUtil.js"></script>
 
    <script type="text/javascript" src="${CP_RES }/js/review/review_write_popup.js"></script>
    
    <script type="text/javascript">
    $(document).ready(function(){
        //--doReviewInsert
        $("#doReviewInsert").on("click",function(e){
            if(eUtil.ISEmpty($("#oName").val())) {
                alert("다시 시도해주세요");
                $("#oName").focus();
                
                return;
            }

            if(eUtil.ISEmpty($("#rContent").val())) {
                alert("리뷰 내용을 작성해주세요");
                $("#rContent").focus();
                
                return;
            }
            let url = "${CP}/review/doReviewInsert.do";
            let method = "GET";
            let parameters = {
                    dNum : $("#dNum").val(),
                    oNum : $("#oNum").val(),
                    rContent : $("#rContent").val(),
                    oName : $("#oName").val(),
                    pNum : $("#pNum").val()
            };
            
            let async = false;
            EClass.callAjax(url, parameters, method, async, function(data){
                console.log('data.pNum:'+data.pNum);
                let pNum = data.pNum;
                let pName = data.pName;
                let pPrice = data.pPrice;
                let pSize = data.pSize;
                
                if(null != data) {
                    alert("리뷰가 등록되었습니다!");
                    opener.location.href="${CP}/productDetail/view.do?pNum=" + pNum + "&pName=" + pName + 
                            "&pPrice="+pPrice + "&pSize="+pSize;                
                    window.close();                 
                }else {
                    alert("다시 시도해주세요.^^");
                    window.close();
                } 
            }); 
            
            //--doReviewInsert
        });

    //--$(document).ready       
    });
    </script>
</head>
<body>
   <div class="container">
     <p>상품에 대한 리뷰를 작성해주세요</p>
       <form method="get" action="#" name="reviewFrm" id="reviewFrm">
          <!--주문 상세 번호-->
          <input type="text" id="dNum" name="dNum" value="${dNum}"/> 
          <!--주문 번호-->
          <input type="text" id="oNum" name="oNum" value="${oNum}"/> 
          <!--상품 번호-->
          <input type="text" id="pNum" name="pNum" value="${pNum}"/> 
          
          <!-- 입력받는 부분 -->
          <ul>
            <li><label for="oName">작성자</label></li>
            <li class="border_bottom"><input type="text" name="oName" id="oName" readonly="readonly" value="${oName}"/></li>
            <li><label for="rContent">내용</label></li>
            <li><textarea rows="10" cols="40" name="rContent" id="rContent"></textarea></li>
            <li><input type="button" id="doReviewInsert" class="btn-1 button" value="REVIEW WRITE"></li>
          </ul>
          <!--// 입력받는 부분 -->
          
       </form>
   </div>

</body>
</html>