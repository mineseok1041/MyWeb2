<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="id" value="${sessionScope.id}" />
<c:set var="name" value="${sessionScope.name}" />

<c:url var="loginUrl" value="/login.jsp" />
<c:url var="logoutUrl" value="/member/logout.do" />
<c:url var="signupUrl" value="/signup.jsp" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="qcss/index.css" />
<title>Main page</title>
</head>

<body>
	<h1>Main Page</h1>
	
	<!-- 로그인이 안되어 있을 때 -->
	<c:if test="${empty id}">
		<a href="${loginUrl}">로그인</a>
		<a href="${signupUrl}">회원가입</a>
	</c:if>
	
	<!-- 로그인이 되어 있을 때 -->
	<c:if test="${not empty id}">
        ${name}님 환영합니다.<br>
		<a href="${logoutUrl}">로그아웃</a>
	</c:if>
	
	<style>
        
    </style>
</body>

</html>
