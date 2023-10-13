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
<h1>1. Mysql Driver 설치 - pox.xml</h1>
<h3>
<pre><code>
&lt;dependency&gt;
    &lt;groupId>mysql&lt;/groupId&gt;
    &lt;artifactId>mysql-connector-java&lt;/artifactId&gt;
    &lt;version>8.0.33&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>
</h3>

<h1>2. Spring Annotation 애너테이션</h1>
<h3>
<ul>servlet-context.xml
<li>&lt;context:component-scan base-package="com.myweb" /></li>
<li>&lt;annotation-driven /></li>
</ul>
<ul>JAVA
<li>Controller : @Controller</li>
<li>Rest Controller : @RestController</li>
<li>Service : @Service - 구현체(Impl)</li>
<li>DAO : @Repository</li>
</ul>
</h3>


</body>
</html>