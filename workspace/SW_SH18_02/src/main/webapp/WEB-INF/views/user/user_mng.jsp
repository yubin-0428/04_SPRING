<%--
/**
    Class Name:
    Description:
    Modification information
        
        수정일     수정자      수정내용
    -----   -----  -------------------------------------------
    2022. 6. 20.        최초작성 
    
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
    <link rel="shortcut icon" type="image/x-icon" href="${CP }/favicon.ico">
    <title>부트 스트랩-boot_list</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES}/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES}/js/bootstrap.min.js"></script>
        
    <script type="text/javascript">
      $(document).ready(function(){
        console.log("document.ready");  
          
      });
      
      
    </script>
</head>
<body>
       <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>회원관리</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
          
          <!-- 검색영역 -->
          <div class="row">
            <form action="#" class="form-inline col-sm-12 col-md-12 col-lg-12 text-right">
               <div class="form-group">
                 <select class="form-control  input-sm">
                    <option value="">전체</option>
                    <option value="10">아이디</option>
                    <option value="20">이름</option>
                    <option value="30">이메일</option>
                 </select>
                 <input type="text" class="form-control  input-sm"  placeholder="검색어" />
                 <select class="form-control  input-sm">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                    <option value="30">50</option>
                    <option value="30">100</option>
                 </select>  
               <input type="button" class="btn btn-primary btn-sm" value="목록" />
               </div>
            </form>
          
          </div>
          <!--// 검색영역 ----------------------------------------------------------->
          
          
          <!-- tabble -->
          <div class="table-responsive">
           <table class="table table-striped table-bordered table-hover table-condensed">
               <thead class="bg-primary">
                 <tr>
                     <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">아이디</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">이름</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">등급</th>
                     <th class="text-center col-sm-3 col-md-3 col-lg-2">이메일</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-2">등록일</th>
                 </tr>
               </thead>
               <tbody>
                <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                 <tr>
                     <td class="text-center col-sm-1 col-md-1 col-lg-1">1</td>
                     <td class="text-left   col-sm-2 col-md-2 col-lg-2">jamesol</td>
                     <td class="text-left col-sm-2 col-md-2 col-lg-2">이상무</td>
                     <td class="text-center col-sm-2 col-md-2 col-lg-2">BASIC</td>
                     <td class="text-left col-sm-3 col-md-3 col-lg-2">jamesol@paran.com</td>
                     <td class="text-center  col-sm-2 col-md-2 col-lg-2">2022-06-22</td>
                 </tr>                                                           
               </tbody>
           </table>
          </div>
          <!--// tabble ----------------------------------------------------------->
          <!-- pagenation -->
        <div  class="text-center">
           <nav>
              <ul class="pagination">
                <li>
                  <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                  <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                  </a>
                </li>
              </ul>
            </nav>         
        </div>        
          <!--//pagenation ------------------------------------------------------>
          
       </div>
       <!--// div container --------------------------------------------------->
       <!-- div container -->
       <div class="container">
       <!-- 버튼 -->
       <div class="row text-right">
        <label class="col-sm-3 col-md-2 col-lg-2"></label>
        <div class="col-sm-9 col-md-10 col-lg-10">
           <input type="button" class="btn btn-primary btn-sm" value="초기화" />
           <input type="button" class="btn btn-primary btn-sm" value="수정" />
           <input type="button" class="btn btn-primary btn-sm" value="삭제" />
           <input type="button" class="btn btn-primary btn-sm" value="목록" />       
        </div>
      </div> 
      
    <!-- form -->
    <form action="" class="form-horizontal">
      <div class="form-group">
        <label for="uId" class="col-sm-3 col-md-2 col-lg-2 control-label">아이디</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="20" name="uId" id="uId" placeholder="아이디" class="form-control">
        </div>
      </div>  
      <div class="form-group">
        <label for="name" class="col-sm-3 col-md-2 col-lg-2 control-label">이름</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="20" name="name" id="name" placeholder="이름" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label for="passwd" class="col-sm-3 col-md-2 col-lg-2 control-label">비번</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="20" name="passwd" id="passwd" placeholder="비번" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label for=intLevel class="col-sm-3 col-md-2 col-lg-2 control-label">등급</label>
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
          <input type="text" maxlength="8" name="login" id="login" placeholder="로그인" class="form-control">
        </div>
      </div>    
      <div class="form-group">
        <label for="recomment" class="col-sm-3 col-md-2 col-lg-2 control-label">추천</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="8" name="recomment" id="recomment" placeholder="추천" class="form-control">
        </div>
      </div>    
      <div class="form-group">
        <label for="email" class="col-sm-3 col-md-2 col-lg-2 control-label">이메일</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="320" name="email" id="email" placeholder="아메일" class="form-control">
        </div>
      </div>    
      <div class="form-group">
        <label for="email" class="col-sm-3 col-md-2 col-lg-2 control-label">등록일</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="320" name="regDt" id="regDt" placeholder="등록일" class="form-control" readonly="readonly">
        </div>
      </div>    
    </form>
    <!--// form  -------------------------------------------------------------->                
       <!--// div container -->
</body>
</html>