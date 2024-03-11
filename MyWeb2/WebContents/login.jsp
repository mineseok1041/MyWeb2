<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="LoginErr" value="${requestScope.LoginErr}" />

<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
</head>

<body>
	<div>
		<form name="login" method="post" action="member/login.do">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
			</table>
			<input type="submit" value="로그인" />
		</form>
	</div>
	<div>
		<c:if test="${LoginErr =='true'}">
			아이디 또는 비밀번호가 틀렸습니다.
		</c:if>
	</div>
</body>
</html>