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
<h1>1. pom.xml 설정</h1>
<hr>
<h3>
1) JDBC 설정 - Mysql Driver 설치
<pre><code>
&lt;dependency&gt;
    &lt;groupId>mysql&lt;/groupId&gt;
    &lt;artifactId>mysql-connector-java&lt;/artifactId&gt;
    &lt;version>8.0.33&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

2) DBCP2 설정 - DB Pool Library 설치
<pre><code>
&lt;dependency&gt;
    &lt;groupId>org.apache.commons&lt;/groupId&gt;
    &lt;artifactId>commons-dbcp2&lt;/artifactId&gt;
    &lt;version>2.10.0&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

3) Spring-JDBC 설정 - Mysql Driver 설치
<pre><code>
&lt;dependency&gt;
    &lt;groupId>org.springframework&lt;/groupId&gt;
    &lt;artifactId>spring-jdbc&lt;/artifactId&gt;
    &lt;version>&#36;{org.springframework-version}&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

4) Mybatis 설정 - Mybatis Library 설치
<pre><code>
&lt;dependency&gt;
    &lt;groupId>org.mybatis&lt;/groupId&gt;
    &lt;artifactId>mybatis&lt;/artifactId&gt;
    &lt;version>3.5.13&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

5) Mmybiatis-Spring 설정 - Mybatis-Spring Library 설치
<pre><code>
&lt;dependency&gt;
    &lt;groupId>org.mybatis&lt;/groupId&gt;
    &lt;artifactId>mybatis-spring&lt;/artifactId&gt;
    &lt;version>2.1.1&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>

</h3>
<hr>
<h1>2. DataSource 설정</h1>
<hr>
<h3>
root-context.xml <br>
classpath : src/main/resources
<pre><code>
&lt;!-- for mysql -->
 &lt;bean id="dataSource"
  class="org.apache.commons.dbcp2.BasicDataSource"
  destroy-method="close">
  &lt;property name="driverClassName"
   value="com.mysql.cj.jdbc.Driver" />
  &lt;property name="url"
   value="jdbc:mysql://localhost:3306/jspdb?serverTimezone=UTC&amp;useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8" />
  &lt;property name="username" value="root" />
  &lt;property name="password" value="rpass" />
 &lt;/bean>

&lt;!-- for mybatis -->
 &lt;bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
  &lt;property name="dataSource" ref="dataSource" />
  &lt;property name="configLocation" value="classpath:com/myweb/mybatis/mybatis-config.xml" />
 &lt;/bean>
 &lt;bean id="sqlSessionTemplate" class="org.mybatis.spring.SqlSessionTemplate">
  &lt;constructor-arg index="0" ref="sqlSessionFactory" />
 &lt;/bean>  
</code></pre>

</h3>

<hr>
<h1>3. mybatis-config.xml</h1>
<hr>
<h3>

<pre><code>
&lt;?xml version="1.0" encoding="UTF-8" ?>
&lt;!DOCTYPE configuration
  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
  "https://mybatis.org/dtd/mybatis-3-config.dtd">
&lt;configuration>

  &lt;typeAliases>
  	&lt;typeAlias type="com.myweb.dto.MemberDTO" alias="memberDTO"/>
  &lt;/typeAliases>

  &lt;mappers>
    &lt;mapper resource="com/myweb/mybatis/mapper/member.xml"/>    
  &lt;/mappers>
  
&lt;/configuration>
</code></pre>

</h3>

</body>
</html>