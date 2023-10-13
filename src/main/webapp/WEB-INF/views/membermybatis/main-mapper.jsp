<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=request.getRequestURI() %></title>
</head>
<body>
<%@include file="submenu.jsp" %>
<h1>1. Mybatis - Interface() 사용</h1>
<h2>mapper(xml), 인터페이스 이름(패키지 포함)이 같아야 한다.</h2>
<hr>
<h3>
1) root-context.xml
<ul>
<li>Namespaces - mybatis-spring 추가</li>
</ul>
<pre><code>
&lt;mybatis-spring:scan base-package="com.myweb.mybatis.mapper"/>
</code></pre>

2) mapper XML - MemberMapper.xml 파일 생성
<pre><code>
&lt;?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper 
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

&lt;mapper namespace="com.myweb.mybatis.mapper.MemberMapper">

&lt;/mapper>
</code></pre>

3) Interface - MemberMapper.java 파일 생성
<pre><code>
package com.myweb.mybatis.mapper;

public interface MemberMapper {	

}
</code></pre>
</h3>


</body>
</html>