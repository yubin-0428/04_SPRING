<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
h1{
    text-align: center;
}
 
</style>
<meta charset="UTF-8">
<title>회원 정보 조회 페이지</title>
</head>
<body>
<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
    String name_1 = request.getParameter("name");
    MemberVO infoVO = new MemberVO();
    infoVO.setName(name_1);
    MemberDAO dao = new MemberDAO();
    List infosList = dao.listinfos(infoVO);
%>
<table border=1 style="width:800px;align:center">
    <tr align=center bgcolor="#FFFF66">
        <th>아이디</th>
        <th>비밀번호</th>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일자</th>
    </tr>
    <%
    	for(int i=0; i<infosList.size(); i++){
                    MemberVO vo = (MemberVO) infosList.get(i);
                    String id=vo.getId();
                    String pwd = vo.getPwd();
                    String name = vo.getName();
                    String email = vo.getEmail();
                    Date joinDate = vo.getJoinDate();
    %>
    
    <tr align="center">
        <td><%= id %></td>
        <td><%= pwd %></td>
        <td><%= name %></td>
        <td><%= email %></td>
        <td><%= joinDate %></td>
    </tr>
    <%    
        }
    %>
</table>
 
</body>
</html>
