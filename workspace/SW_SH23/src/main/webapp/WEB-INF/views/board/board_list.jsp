<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CP" value="${pageContext.request.contextPath}" />
<c:set var="resources" value="/resources"/>
<c:set var="CP_RES" value="${CP}${resources}"/>

<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>게시 목록</title>
    
    <!-- 부트스트랩 -->
    <link href="${CP_RES }/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/jquery-1.12.4.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/eclass.js"></script>
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/eUtil.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="${CP_RES }/js/bootstrap.min.js"></script>
    <!-- jquery_bootstrap paging -->
    <script type="text/javascript" src="${CP_RES}/js/jquery.bootpag.js"></script>
    
    <script type="text/javascript">
        $(document).ready(function(){
            console.log("document.ready");
            
            renderingPage('${pageTotal}', 1)
            
            // 데이터 클릭
            $("#board_table>tbody").on("click","tr",function(e){
            	console.log("#board_table>tbody");
            	let tdArray = $(this).children();
                let boardSeq = tdArray.eq(5).text();
                console.log("boardSeq"+boardSeq);
                
                if(confirm("상세 조회를 하시겠습니까?")==false)return;
                
                window.location.href="${CP}/board/doSelectOne.do?seq="+boardSeq;
            	
            });
            
            // 등록화면으로 이동
            $("#moveToReg").on("click", function(e) {
            	console.log("moveToReg:");
            	console.log("div:"+$("#div").val());
            	window.location.href="${CP}/board/moveToReg.do?div="+$("#div").val(); // 특정 URL로 이동!
            });
            
            //paging
            function renderingPage(pageTotal, page){
            	console.log("pageTotal"+pageTotal); // 소숫점
            	console.log("page"+page);
            	
            	pageTotal = parseInt(pageTotal);
            	console.log("pageTotal"+pageTotal); // 정수
            	
            	//이전 연결된 EventHandler제거
                $('#page-selection').unbind('page');
                $('#page-selection').bootpag({
                    total: pageTotal, 
                    page: page,
                    maxVisible: 10,
                    leaps: true,
                    firstLastUse: true,
                    first: '←',
                    last: '→',
                    wrapClass: 'pagination',
                    activeClass: 'active',
                    disabledClass: 'disabled',
                    nextClass: 'next',
                    prevClass: 'prev',
                    lastClass: 'last',
                    firstClass: 'first'
                }).on("page", function(event, num){
                    console.log("num:"+num);
                    doRetrieve(num);
                });  
            }
            
            // 검색어 enter event
            $("#searchWord").on("keypress",function(e){
                console.log("searchWord:"+e.which);
                
                if(13==e.which){
                    doRetrieve(1);
                }
            });
            
            function doRetrieve(page) {
                console.log("function doRetrieve");
                console.log("page: " + page);
                
                let url = "${CP}/board/doRetrieve.do";
                let method = "GET";
                let async = true;
                let parameters = {
                        searchDiv: $("#searchDiv").val(),
                        searchWord: $("#searchWord").val(),
                        pageSize: $("#pageSize").val(),
                        pageNum: page,
                        div: $("#div").val()
                };
                
                EClass.callAjax(url, parameters, method, async, function(data) {
                    console.log("EClass.callAjax data : " + data);
                    
                    // 기존 table 데이터 삭제
                    // 동적으로 table 데이터 표시
                    
                    let parsedData = data;
                    
                    $("#board_table > tbody").empty(); // 기존 데이터 삭제
                    
                    console.log("parsedData.length : " + parsedData.length);
                    
                    let htmlData = ""; // 동적으로 tbody아래 데이터 생성
                    let totalCnt = 0; // 총글수
                    let pageTotal = 1; // 페이지 수
                    
                    // 조회 데이터가 있는 경우
                    if(null != parsedData && parsedData.length > 0) {
                       
                       $.each(parsedData, function(i, boardVO){
                            htmlData += " <tr>                                                                       ";
                            htmlData += "     <td class='text-center col-sm-1 col-md-1 col-lg-1'>"+ <c:out value='boardVO.num' />+"</td> ";
                            htmlData += "     <td class='text-left   col-sm-6 col-md-6 col-lg-8'>"+ <c:out value='boardVO.title' />+"</td>";
                            htmlData += "     <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+ <c:out value='boardVO.modId' />+"</td>";
                            htmlData += "     <td class='text-center col-sm-2 col-md-2 col-lg-1'>"+ <c:out value='boardVO.modDt' />+"</td>";
                            htmlData += "     <td class='text-right  col-sm-1 col-md-1 col-lg-1'>"+ <c:out value='boardVO.readCnt' />+" </td>";
                            htmlData += "     <td style='display:none;'>"+<c:out value='boardVO.seq' />+"</td>";
                            htmlData += " </tr>                                                                      ";
                       });
                       
                    }else {
                        htmlData += " <tr>                                   ";
                        htmlData += "    <td colspan='99' class='text-center'>No data found</td> ";
                        htmlData += " </tr>                                  ";
                    }
                    // 조회 데이터가 없는 경우
                    $("#board_table > tbody").append(htmlData);
                })
                
            }
            
            $("#doRetrieve").on("click", function(e) {
                console.log("doRetrieve");
                doRetrieve(1);
            });
        });
    </script>
    
</head>
<body>
       <!-- div container -->
       <div class="container">
          <!-- 제목 -->
          <div class="page-header">
              <h2>게시 목록</h2>
          </div>
          <!--// 제목 ----------------------------------------------------------->
          pageTotal:${pageTotal}
          <!-- 검색영역 -->
          <div class="row">
            <form action="#" class="form-inline col-sm-12 col-md-12 col-lg-12 text-right">
               <input type="hidden" name="div" id="div" value="${vo.getDiv()}">
               <div class="form-group ">
                 <select class="form-control  input-sm" name="searchDiv" id="searchDiv">
                    <option value="">전체</option>
                    <option value="10">제목</option>
                    <option value="20">내용</option>
                 </select>
                 <input type="text" class="form-control  input-sm" name="searchWord" id="searchWord" placeholder="검색어" />
                 <select class="form-control  input-sm" name="pageSize" id="pageSize">
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="30">30</option>
                 </select>  
               <input type="button" id="doRetrieve" class="btn btn-primary btn-sm" value="목록" />
               <input type="button"class="btn btn-primary btn-sm" value="등록" id="moveToReg"/>                              
               </div>
            </form>
          
          </div>
          <!--// 검색영역 ----------------------------------------------------------->
          
          
          <!-- table -->
          <div class="table-responsive">
           <table id="board_table" class="table table-striped table-bordered table-hover table-condensed">
               <thead class="bg-primary">
                 <tr>
                     <th class="text-center col-sm-1 col-md-1 col-lg-1">번호</th>
                     <th class="text-center col-sm-6 col-md-6 col-lg-8">제목</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-1">작성자</th>
                     <th class="text-center col-sm-2 col-md-2 col-lg-1">작성일</th>
                     <th class="text-center col-sm-1 col-md-1 col-lg-1">조회수</th>
                     <th style="display:none;">boardId</th>
                 </tr>
               </thead>
               <tbody>
                <!-- 문자: 왼쪽, 숫자: 오른쪽, 같은면: 가운데 -->
                <c:choose>
                    <c:when test="${list.size() > 0}">
                        <c:forEach var="vo" items = "${list}">
                             <tr>
                                 <td class="text-center col-sm-1 col-md-1 col-lg-1">${vo.num}</td>
                                 <td class="text-left   col-sm-6 col-md-6 col-lg-8">${vo.title}</td>
                                 <td class="text-center col-sm-2 col-md-2 col-lg-1">${vo.modId}</td>
                                 <td class="text-center col-sm-2 col-md-2 col-lg-1">${vo.modDt}</td>
                                 <td class="text-right  col-sm-1 col-md-1 col-lg-1">${vo.readCnt}</td>
                                 <td style="display:none;">${vo.seq}</td>
                             </tr>                         
                        </c:forEach>
                    </c:when>  
                    <c:otherwise>
                        <tr>
                            <td>No data found</td>
                        </tr>
                    </c:otherwise>            
                 </c:choose>                                               
               </tbody>
           </table>
          </div>
          <!--// tabble ----------------------------------------------------------->
          <!-- pagenation -->
          <div  class="text-center col-sm-12 col-md-12 col-lg-12">
            <div id="page-selection" class="text-center page"></div>
          </div>
          <!--//pagenation ------------------------------------------------------>
          
       </div>
       <!--// div container --------------------------------------------------->
       
</body>
</html>s