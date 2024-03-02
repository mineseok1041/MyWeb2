<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Blog List Page</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/qcss/blogList.css">
</head>

<body>
	<h1>Blog List Page</h1>
	<a href="${contextPath}">홈으로</a>
	<table class="table">
		<tr class="contype">
			<td class="title">제목</td>
			<td class="writer">작성자</td>
			<td class="date">작성일</td>
		</tr>
		<tr>
			<c:if test="${empty BlogList}">
			    <td>게시글이 없습니다.</td>
			</c:if>

			<c:if test="${not empty BlogList}">
				<c:forEach items="${BlogList}" var="blog">
				<tr>
					<td><a href="${contextPath}/blog/viewBlog/${blog.blogNum}">${blog.title}</a></td>
					<td>${blog.writer}</td>
					<td><fmt:formatDate value="${blog.writeDate}"
										pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
			</c:if>
			
		</tr>
	</table>

	
	
	
</body>
</html>