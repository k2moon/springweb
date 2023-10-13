<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function deleteConfirm() {
		const input = confirm("회원을 탈퇴할까요?");
		alert(input);
		if (input) location.href = "delete";
		else return;
	};
	
</script>
<%@include file="../topmenu.jsp" %>
<%@include file="../subject.jsp" %>
<h2>
<a href="main">Home</a> |
<a href="main-mapper">Home-mapper</a> |

<a href="memberList">회원목록</a> |
<a href="memberList-mapper">회원목록-Interface(mapper)</a> |


</h2>
<hr>