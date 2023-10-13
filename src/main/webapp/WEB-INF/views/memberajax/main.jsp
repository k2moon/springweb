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
<h2><%=request.getRequestURI() %></h2>
<hr>
<h2>
1. pom.xm에 Jackson2 라이브러리 추가
<pre><code>
&lt;dependency&gt;
    &lt;groupId>com.fasterxml.jackson.core&lt;/groupId&gt;
    &lt;artifactId>jackson-databind&lt;/artifactId&gt;
    &lt;version>2.15.2&lt;/version&gt;
&lt;/dependency&gt;
</code></pre>
2. 메서드에 추가 : @ResponseBody
<pre><code>
@RequestMapping(value = "/listJson")
@ResponseBody
public List listJson() {  
}
</code></pre>
3. API 전용 클래스 생성: @RestController
<pre><code>
@RestController
@RequestMapping("api")
public class MemberControllerApi {

}
</code></pre>
</h2>
</body>
</html>