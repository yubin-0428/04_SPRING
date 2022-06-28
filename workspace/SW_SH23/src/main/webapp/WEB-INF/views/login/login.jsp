<%--
/**
	Class Name: login.jsp
	Description: 로그인
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
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <link rel="shortcut icon" type="image/x-icon" href="${CP}/favicon.ico">    
    <title>로그인</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
    <!-- 사용자 정의 function, ISEmpty -->
    <script src="${CP_RES}/js/eUtil.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES}/js/eclass.js"></script>
            
    <script type="text/javascript">
      $(document).ready(function(){
    	console.log("document.ready");  
    	
    	
        //검색어 Enter
        $("#passwd").on("keypress",function(e){
            console.log("passwd"+e.which);  
            if(13==e.which){
                e.preventDefault();
              //trigger통한 호출: 로그인 호출
                $( "#doLogin" ).trigger( "click" );
            }
            
        });
        
        
    	$("#doLogin").on("click",function(){
    		console.log("doLogin");
    		
    		if(eUtil.ISEmpty($("#uId").val())){
    			alert("아이디를 입력 하세요.")
    			$("#uId").focus();
    			return;
    		}
    		
            if(eUtil.ISEmpty($("#passwd").val())){
                alert("비밀번호를 입력 하세요.")
                $("#passwd").focus();
                return;
            }    		
            
            
            if(confirm("로그인 하시겠습니까?")==false)return;
            
            
            let url = "${CP}/login/doLogin.do";
            let method = "POST";
            let async  = true;
            let parameters = {
            		"uId": $("#uId").val(),
            		"passwd":$("#passwd").val()
            };
            
            EClass.callAjax(url, parameters, method, async, function(data) {
            	
            	if("10" == data.msgId){//ID확인
            		alert(data.msgContents);
            		$("#uId").focus();
            	}else if("20" == data.msgId){//비번확인
                    alert(data.msgContents);
                    $("#passwd").focus();
            	}else if("30" == data.msgId){//id/비번 통과
                    alert(data.msgContents);
            	    //특정페이지로 이동: main.jsp
            	    
            	    window.location.href ="${CP}/main/mainView.do";
            	    
            	    
                }else{
                    alert(data.msgContents);
                    $("#uId").focus();
                } 
            	
            	
            });
            
            
            
    		
    	});
    	  
      });
      
      
    </script>
</head>
<body> 
       
       <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>로그인</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
   
		      
	        <div class="row text-left col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
                 <form class="form-inline" action="${CP}/login/doLogin.do" method="post">
                    <input type="text" class="form-control" name="uId" id="uId" 
                    maxlength="20" placeholder="아이디">
                    <input type="password"  class="form-control"  name="passwd" id="passwd"
                    maxlength="50" placeholder="비밀번호">
                    <input type="button" class="btn btn-default btn-primary" value="로그인" id="doLogin">
                 </form>
	        </div>
        	      
      </div>
</body>
</html>




