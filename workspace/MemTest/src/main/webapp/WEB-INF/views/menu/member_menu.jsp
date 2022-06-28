<%--
/**
	Class Name: tmp_menu.jsp
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <script type="text/javascript">
    $(document).ready(function(){
    	console.log("document.ready");
    });
    </script>
<head>

</head>
<body>
    <!-- div container -->
    <div class="container">
        <!-- 제목 -->
        <div class="page-header">
            <h2>멤버 로그인</h2>
        </div>
        <!-- 제목 ---------------------------------------->
        
        <!-- table -->
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover table-condensed" border="1">
                <thead class="bg-primary">
                    <tr>
                    <th class="text-center col-sm-2 col-md-2 col-lg-2">번호</th>
                    <th class="text-center col-sm-10 col-md-10 col-lg-10">제목</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td class="text-center col-sm-2 col-md-2 col-lg-2">1</td>
                    <td class="text-left col-sm-10 col-md-10 col-lg-10"><a href="${CP}/member/list.do">마이페이지</a></td>
                    </tr>                              
                </tbody>
            </table>
        </div>
        <!-- table ---------------------------------------->
        
    </div>
    <!-- div container --------------------------------->
</body>
</html>
</html>