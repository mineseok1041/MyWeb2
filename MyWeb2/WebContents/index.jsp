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
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        a {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            text-decoration: none;
            color: #fff;
            background-color: #4caf50;
            border-radius: 5px;
        }

        a:hover {
            background-color: #45a049;
        }
    </style>
</body>

</html>
