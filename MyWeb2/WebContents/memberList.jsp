<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List Page</title>
</head>
<body>
    <c:if test="${sessionScope.id != 'admin'}">
	    <script>
	    	alert('관리자만 접근 가능합니다.');
	    	location.href='${contextPath}/member/login.do';
	    </script>
	</c:if>
    <c:if test="${sessionScope.id eq 'admin'}">
    	<h3>회원 목록</h3>
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>가입일</td>
			</tr>
			<c:forEach var="member" items="${BlogList}">
			<tr>
				<td>${member.id}</td>
				<td>${member.pw}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.joinDate}</td>
				<td><a href="${contextPath}/member/delMember.do?id=${member.id}">회원삭제</a></td>
			</tr>
			</c:forEach>
		</table>
    </c:if>
</body>
</html>