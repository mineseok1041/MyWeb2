<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>

<%
	request.setCharacterEncoding("UTF-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loginID" value="${sessionScope.id}" />

<c:set var="blogNum" value="${BlogDTO.blogNum}" />
<c:set var="title" value="${BlogDTO.title}" />
<c:set var="contents" value="${BlogDTO.contents}" />
<c:set var="writerID" value="${BlogDTO.writerID}" />

<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Update Blog Page</title>
</head>

<body>
	<c:if test="${writerID == loginID}">
		<form action="${contextPath}/blog/updateBlog.do" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" value="${title}" required /></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="contents" cols="30" rows="5">${contents}</textarea></td>
				</tr>
			</table>
			<input type="hidden" name="blogNum" value="${blogNum}" /> 
			<input type="submit" value="수정" />
		</form>
	</c:if>
	
	<c:if test="${writerID != loginID}">
		<script>
			alert('글 작성자만 수정할 수 있습니다.'); 
			location.href='${contextPath}';
		</script>
	</c:if>
</body>
</html>