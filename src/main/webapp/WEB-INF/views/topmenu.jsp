<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>
<h1>Java Web Application </h1>  
<h2>
<a href="<%=contextPath %>">Home</a> |
<a href="<%=contextPath %>/request">Request</a> |
<a href="<%=contextPath %>/member/main">Member</a> |
<a href="<%=contextPath %>/memberajax/main">Member-AJAX</a> |
<a href="<%=contextPath %>/membermybatis/main">Member-Mybatis</a> |
<a href="<%=contextPath %>/membermybatis/main-mapper">Member-Mybatis-Mapper</a> |

</h2>
<hr>