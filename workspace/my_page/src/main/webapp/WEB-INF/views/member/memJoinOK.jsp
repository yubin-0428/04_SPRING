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
//--doRetrieve
$("#doRetrieve").on(
      "click",
      function(e) {
         console.log("doRetrieve");
         let url = "${CP}/member/doRetrieve.do";
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
                             htmlData += "   <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+value.memId    +"</td>";
                             htmlData += "   <td class='text-left col-sm-2 col-md-6 col-lg-2'  >"+value.memPw    +"</td>    ";
                             htmlData += "   <td class='text-left col-sm-2 col-md-6 col-lg-2'  >"+value.memMail   +"</td>   ";
                             htmlData += "   <td class='text-center col-sm-2 col-md-6 col-lg-2'>"+value.memPhone1  +"</td>";
                             htmlData += "   <td class='text-left col-sm-3 col-md-6 col-lg-3'  >"+value.memPhone2  +"</td>  ";
                             htmlData += "   <td class='text-center col-sm-2 col-md-6 col-lg-2'>"+value.memPhone3  +"</td>";
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
   
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
                           <td class="text-center col-sm-1 col-md-1 col-lg-1">${vo.memId }</td>
                           <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.memPw }</td>
                           <td class="text-left col-sm-2 col-md-6 col-lg-2">${vo.memMail }</td>
                           <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.memPhone1 }</td>
                           <td class="text-left col-sm-3 col-md-6 col-lg-3">${vo.memPhone2 }</td>
                           <td class="text-center col-sm-2 col-md-6 col-lg-2">${vo.memPhone3 }</td>
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
</body>
</html>