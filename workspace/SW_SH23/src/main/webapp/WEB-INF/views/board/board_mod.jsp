<%--
/**
   Class Name: boot_reg.jsp
   Description: 부트스트랩 등록
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
    
    <title>게시등록</title>
    <!-- 부트스트랩 -->
    <link href="${CP_RES }/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${CP_RES }/js/jquery-1.12.4.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <!-- 사용자 정의 function, isEmpty -->
    <script src="${CP_RES }/js/eUtil.js"></script>
    <!-- 사용자 정의 function, callAjax -->
    <script src="${CP_RES }/js/eclass.js"></script>
    
    <script src="${CP_RES }/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${CP_RES }/js/jquery.bootpag.js"></script>
    
    <script type="text/javascript">
    $(document).ready(function(){
       console.log("document.ready");
       
       $("#doDelete").on("click", function(e){
    	    console.log("doDelete");
    	    let boardId = $("seq").val();
    	    console.log("boardId"+boardId);
    	    
    	    if(eUtil.ISEmpty(boardId)){
    	    	alert("게시 순번을 확인하세요");
    	    	return;
    	    }
    	    
    	    if(confirm("삭제 하시겠습니까?")==flase)return;
    	    
    	    let url = "${CP}/board/doDelete.do";
    	    let method = "POST";
    	    let async = true;
    	    let parameters = {
                    "seq":boardId,
              };
    	    
    	    ECLass.callAjax(url, parameters, method, async,function(data){
    	    	console.log("data.msgId :"+ data.msgId);
                console.log("data.msgContents :"+ data.msgContents);
                
                if("1" == data.msgId){
                   alert(data.msgContents);
                   moveToList();
                }else{
                   alert(data.msgContents);
                }
                
                });
       })
       
       function moveToList(){
            window.location.href = "${CP}/board/boardView.do";
       }
       
       $("#moveToList").on("click", function(){
          moveToList();
       });
       
       $("#doInsert").on("click", function(e){
          console.log("doInsert");
          if(eUtil.ISEmpty($("#title").val())){
             alert("제목을 입력하세요");
             $("#title").focus();
             return;
          }
          if(eUtil.ISEmpty($("#regId").val())){
             alert("등록자를 입력하세요");
                $("#regId").focus();
                return;
          }
            if(eUtil.ISEmpty($("#contents").val())){
                alert("내용을 입력하세요");
                $("#contents").focus();
                return;
            }          
            if(confirm("등록하시겠습니까?") == false) return;
            
            let url = "${CP}/board/doInsert.do";
            let method = "POST";
            let parameters = {
                  "title":$("#title").val(),
                  "regId":$("#regId").val(),
                  "contents":$("#contents").val(),
                  "div":$("#div").val()
            };
            
            let async = true;
            
            EClass.callAjax(url, parameters, method, async, function(data){
                console.log("data.msgId :"+ data.msgId);
                console.log("data.msgContents :"+ data.msgContents);
                
                if("1" == data.msgId){
                   alert(data.msgContents);
                   moveToList();
                }else{
                   alert(data.msgContents);
                }
            });
       });
    });
    </script>
<head>

</head>
<body>
  <!-- div container -->
  <div class="container">
    <!-- 제목  -->
    <div class="page-header">
      <h2>게시 등록</h2>
    </div>
    <!--// 제목  ---------------------------------------------------------------->
    <!-- 버튼 -->
    <div class="row text-right">
      <label class="col-sm-3 col-md-2 col-lg-2"></label>
      <div class="col-sm-9 col-md-10 col-lg-10">
        <input type="button" class="btn btn-primary btn-sm" value="수정" id="doUpdate"/>
        <input type="button" class="btn btn-primary btn-sm" value="삭제" id="doDelete"/>
        <input type="button" class="btn btn-primary btn-sm" value="목록" id="moveToList"/>
      </div>
    </div>
    <!--// 버튼  ---------------------------------------------------------------->
    
    <!-- form -->
    <form action="#" class="form-horizontal" method="post">
      
      <div class="form-group">
        <label for="seq" class="col-sm-3 col-md-2 col-lg-2 control-label">순번</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="seq" id="seq" value="<c:out value='${vo.seq}' />" placeholder="순번" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="title" class="col-sm-3 col-md-2 col-lg-2 control-label">제목</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="title" id="title" value="<c:out value='${vo.title}' />" placeholder="제목" class="form-control">
        </div>
      </div>
      
      <div class="form-group">
        <label for="readCnt" class="col-sm-3 col-md-2 col-lg-2 control-label">조회수</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="readCnt" id="readCnt" value="<c:out value='${vo.readCnt}' />" placeholder="조회수" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="div" class="col-sm-3 col-md-2 col-lg-2 control-label">게시구분</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="div" id="div"  value="<c:out value='${vo.getDiv}' />" placeholder="게시구분" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="regId" class="col-sm-3 col-md-2 col-lg-2 control-label">등록자</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="regId" id="regId" value="<c:out value='${vo.regId}' />" placeholder="등록자" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="regDt" class="col-sm-3 col-md-2 col-lg-2 control-label">등록일</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="regDt" id="regDt" value="<c:out value='${sessionScope.user.uId}' />" placeholder="등록일" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="modId" class="col-sm-3 col-md-2 col-lg-2 control-label">수정자</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="modId" id="modId" value="<c:out value='${vo.modId}' />" placeholder="등록일" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <div class="form-group">
        <label for="modDt" class="col-sm-3 col-md-2 col-lg-2 control-label">등록일</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <input type="text" maxlength="100" name="modDt" id="modDt" value="<c:out value='${vo.modDt}' />" placeholder="수정일" class="form-control" readonly="readonly">
        </div>
      </div>
      
      <!-- 내용 -->
      <div class="form-group">
        <label for="contents" class="col-sm-3 col-md-2 col-lg-2 control-label">내용</label>
        <div class="col-sm-9 col-md-10 col-lg-10">
          <textarea rows="5" cols="20" name="contents" id="contents" class="form-control"></textarea>
        </div>
      </div>
      <!--// 내용  -------------------------------------------------------------->
    </form>
    <!--// form  -------------------------------------------------------------->
  </div>
  <!--// div container -------------------------------------------------------->
</body>
</html>