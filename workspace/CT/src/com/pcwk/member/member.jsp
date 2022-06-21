<%@ page language="java" contentType="text/html; charset=UTF-8"    
pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
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
    MemberVO memberVO = new MemberVO();
    memberVO.setName(name_1);
    MemberDAO dao = new MemberDAO();
    List membersList = dao.listmembers(memberVO);
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
        for(int i=0; i<membersList.size(); i++){
            MemberVO vo = (MemberVO) membersList.get(i);
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
