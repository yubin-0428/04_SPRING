<%--
/**
    Class Name:
    Description:
    Modification information
    
    수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 20.        최초작성 
    
    author TeamDMC 개발팀
    since 2022.01.27
    Copyright (C) by KandJang All right reserved.
*/
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="CP" value="${pageContext.request.contextPath }" />
<c:set var="resources" value="/resources" />
<c:set var="CP_RES" value="${CP }${resources }" />
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
<title>부트스트랩 boot_list</title>
<!-- 부트스트랩 -->
<link href="${CP_RES }/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="${CP_RES }/js/jquery-1.12.4.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<!-- 사용자 정의 function, ISEmpty -->
<script src="${CP_RES }/js/eUtil.js"></script>

<!-- 사용자 정의 function, callAjax -->
<script src="${CP_RES }/js/eclass.js"></script>
<script src="${CP_RES }/js/bootstrap.min.js"></script>

<script type="text/javascript">
   //--$(document).ready
   $(document).ready(
         function() {
            console.log("document.ready");
            
            // table click
            $("#user_table>tbody").on("click","tr",function(e){
            	
            	console.log('user_table>tbody>tr')
            	let tds = $(this).children();
            	let uId = tds.eq(1).text();
            	console.log('uId:'+uId);
            	
            	let url = "${CP}/user/doSelectOne.do";
            	let method = "GET";
            	let async = true;
            	let parameters = {"uId":uId};
            	
            	EClass.callAjax(url, parameters,method,async, function(data){
            	    console.log("data:"+data);   
            	    console.log("data.name:"+data.name);   
            	    
            	    $("#uId").val(data.uId);
            	    $("#name").val(data.name);
            	    $("#passwd").val(data.passwd);
            	    $("#intLevel").val(data.intLevel);
            	    $("#login").val(data.login);
            	    $("#login").val(data.login);
            	    $("#recommend").val(data.recommend);
            	    $("#email").val(data.email);
            	    $("#regDt").val(data.regDt);
            	    
            	    // 사용하지 못함으로 처리
            	    $("#uId").prop("disabled","disabled");
            	});
            	
            // ---- table click
            });
            
            //--doRetrieve
            $("#doRetrieve").on(
                  "click",
                  function(e) {
                     console.log("doRetrieve");
                     let url = "${CP}/user/doRetrieve.do";
                     let method = "GET";
                     let async = true;
                     let parameters = {
                        searchDiv : $("#searchDiv").val(),
                        searchWord : $("#searchWord").val(),
                        pageSize : $("#pageSize").val(),
                        pageNum : 1
                     };

                     //console.log("url : " + url);
                     //console.log("method : " + method);
                     //console.log("async : " + async);
                     //console.log("parameters : " + parameters);
                     
                     //parameters에 들어있는 데이터 상세 출력
                     //let paramArray = Object.keys(parameters);
                     //if (paramArray.length > 0) {
                        //for (let i = 0; i < paramArray.length; i++) {
                          // console.log(paramArray[i] + " : "
                            //     + parameters[paramArray[i]]);
                      //  }
                     //}
                     
                     // if(confirm('임시?') == false)return;
                     
                     EClass.callAjax(url,parameters,method,async,function(data){
                    	 console.log("EClass.callAjax data:"+data);
                    	 
                    	 let parsedData = data;
                    	 // 1.
                    	 $("#user_table>tbody").empty();
                    	 
                    	 let htmlData ="";
                    	 
                    	// 데이터가 있는 경우
                         if(null != parsedData && parsedData.length>0){
                        	 $.each(parsedData, function(index, value) {
                                 console.log(index + ", " + value.name);
                                 htmlData += "<tr>                                                                   ";
                                         htmlData += "   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.num    +"</td>";
                                         htmlData += "   <td class='text-left col-sm-2 col-md-6 col-lg-2'  >"+value.uId    +"</td>    ";
                                         htmlData += "   <td class='text-left col-sm-2 col-md-6 col-lg-2'  >"+value.name   +"</td>   ";
                                         htmlData += "   <td class='text-center col-sm-2 col-md-6 col-lg-2'>"+value.level  +"</td>";
                                         htmlData += "   <td class='text-left col-sm-3 col-md-6 col-lg-3'  >"+value.email  +"</td>  ";
                                         htmlData += "   <td class='text-center col-sm-2 col-md-6 col-lg-2'>"+value.regDt  +"</td>";
                                         htmlData += "</tr>                                                                  ";
                              });
                             
                         // 데이터가 없는 경우
                         }else{
                             htmlData += "<tr><td colspan='99' class='text-center'>NO data found</td></tr>";
                         }
                         

                         //2.
                         $("#user_table > tbody").append(htmlData);
                         
                     });

                     //--doRetrieve
                  });

            //--$(document).ready
         });
</script>
<head>

</head>
<body>
   <!-- div container -->
   <div class="container">
      <!-- 제목 -->
      <div class="page-header">
         <h2>회원 관리</h2>
      </div>
      <!-- 제목 ---------------------------------------->

      <!-- 검색영역 -->
      <div class="row">
         <form action="#"
            class="form-inline col-sm-12 col-md-12 col-lg-12 text-right">
            <div class="form-group">
               <select class="form-control input=sm" name="searchDiv"
                  id="searchDiv">
                  <option value="">전체</option>
                  <option value="10">아이디</option>
                  <option value="20">이름</option>
                  <option value="30">이메일</option>
               </select> <input type="text" class="form-control input=sm" placeholder="검색어"
                  name="searchWord" id="searchWord"> <select
                  class="form-control input=sm" name="pageSize" id="pageSize">
                  <option value="10">10</option>
                  <option value="20">20</option>
                  <option value="30">30</option>
                  <option value="50">50</option>
                  <option value="100">100</option>
               </select> <input type="button" id="doRetrieve"
                  class="btn btn-primary btn-sm" value="목록">
            </div>
         </form>

      </div>
      <!-- 검색영역 ---------------------------------------->

      <!-- table -->
      <div class="table-responsive">
         <table id="user_table"
            class="table table-striped table-bordered table-hover table-condensed">
            <thead class="bg-primary">
               <tr>
                  <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
                  <th class="text-center col-sm-2 col-md-6 col-lg-2">아이디</th>
                  <th class="text-center col-sm-2 col-md-6 col-lg-2">이름</th>
                  <th class="text-center col-sm-2 col-md-6 col-lg-2">등급</th>
                  <th class="text-center col-sm-3 col-md-6 col-lg-3">이메일</th>
                  <th class="text-center col-sm-2 col-md-6 col-lg-2">등록일</th>
               </tr>
            </thead>
            <tbody>
               <c:choose>
                  <c:when test="${list.size() > 0 }">
                     <c:forEach var="vo" items="${list }">
                        <tr>
                           <td class="text-center col-sm-1 col-md-1 col-lg-1">${vo.num }</td>
                           <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.uId }</td>
                           <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.name }</td>
                           <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.level }</td>
                           <td class="text-left col-sm-3 col-md-6 col-lg-3">${vo.email }</td>
                           <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.regDt }</td>
                        </tr>

                     </c:forEach>
                  </c:when>
                  <c:otherwise>
                     <tr>
                        <td colspan="99" class="text-center">NO data found</td>
                     </tr>
                  </c:otherwise>
               </c:choose>
            </tbody>
         </table>
      </div>
      <!-- table ---------------------------------------->
      <!-- pagenation -->
      <div class="text-center">
         <ul class="pagination">
            <li><a href="#" aria-label="Previous"> <span
                  aria-hidden="true">&laquo;</span>
            </a></li>
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
            </a></li>
         </ul>
      </div>
      <!-- pagenation ---------------------------------------->
   </div>
   <!-- div container --------------------------------->
   <!-- div container -->
   <div class="container">
      <!-- 버튼 -->
      <div class="row text-right">
         <label class="col-sm-3 col-md-2 col-lg-2"></label>
         <div class="col-sm-9 col-md-10 col-lg-10">
            <input type="button" class="btn btn-primary btn-sm" value="초기화" />
            <input type="button" class="btn btn-primary btn-sm" value="등록" /> <input
               type="button" class="btn btn-primary btn-sm" value="삭제" /> <input
               type="button" class="btn btn-primary btn-sm" value="수정" />
         </div>
      </div>
      <!--// 버튼  ---------------------------------------------------------------->
      <!-- form -->
      <form action="" class="form-horizontal">
         <div class="form-group">
            <label for="uId" class="col-sm-3 col-md-2 col-lg-2 control-label">아이디</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="20" name="uId" id="uId"
                  placeholder="아이디" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="name" class="col-sm-3 col-md-2 col-lg-2 control-label">이름</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="20" name="name" id="name"
                  placeholder="이름" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="passwd" class="col-sm-3 col-md-2 col-lg-2 control-label">비번</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="password" maxlength="20" name="passwd" id="passwd"
                  placeholder="비번" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="intLevel"
               class="col-sm-3 col-md-2 col-lg-2 control-label">등급</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <select name="intLevel" id="intLevel" class="form-control">
                  <option value="1">BASIC</option>
                  <option value="2">SILVER</option>
                  <option value="3">GOLD</option>
               </select>
            </div>
         </div>

         <div class="form-group">
            <label for="login" class="col-sm-3 col-md-2 col-lg-2 control-label">로그인</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="8" name="login" id="login"
                  placeholder="로그인" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="recommend"
               class="col-sm-3 col-md-2 col-lg-2 control-label">추천</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="8" name="recommend" id="recommend"
                  placeholder="추천" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="email" class="col-sm-3 col-md-2 col-lg-2 control-label">이메일</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="320" name="email" id="email"
                  placeholder="이메일" class="form-control">
            </div>
         </div>

         <div class="form-group">
            <label for="regDt" class="col-sm-3 col-md-2 col-lg-2 control-label">등록일</label>
            <div class="col-sm-9 col-md-10 col-lg-10">
               <input type="text" maxlength="320" name="regDt" id="regDt"
                  placeholder="등록일" class="form-control" readonly="readonly">
            </div>
         </div>
      </form>
      <!--// form  -------------------------------------------------------------->

   </div>
   <!-- div container --------------------------------->
</body>
</html>