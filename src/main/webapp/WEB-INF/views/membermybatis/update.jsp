<%@page import="com.myweb.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="loginCheck.jsp" />
<%
request.setCharacterEncoding("utf-8");

MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<%@include file="submenu.jsp" %>
<h2>회원정보수정</h2>
<hr>
<form action="update" method="post">
	<table border="1">
		<tr><th>ID</th><td><%=dto.getId()%></td></tr>
		<tr><th>PW</th><td><input type="text" name="pw" value="<%=dto.getPw()%>"></td></tr>
		<tr><th>Name</th><td><input type="text" name="name" value="<%=dto.getName()%>"></td></tr>
		<tr><th>Role</th><td>
		<%if(dto.getRole().equals("1")){%>	
		<input type="radio" name="role" value="1" checked="checked">Member
		<input type="radio" name="role" value="0">Admin
		<%} %>
		<%if(dto.getRole().equals("0")) {%>
		<input type="radio" name="role" value="1">Member
		<input type="radio" name="role" value="0" checked="checked">Admin
		<%}%>
		</td></tr>
		<tr><td colspan="2"><input type="submit" value="Submit"></td></tr>
	</table>
</form>
</body>
</html>