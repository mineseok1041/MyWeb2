<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="name" value="${sessionScope.name}" />

<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>My Blog List Page</title>
</head>
<body>
	<h3>${name}님의 블로그 목록</h3>
	<a href="${contextPath}">홈으로</a>
	<table class="table">
		<tr class="contype">
			<td class="title" width="400px">제목</td>
			<td class="writer" width="200px">작성자</td>
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
						<td><a href="${contextPath}/blog/updateBlogReq/${blog.blogNum}">수정</a></td>
						<td><a href="${contextPath}/blog/deleteBlog/${blog.blogNum}">삭제</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tr>
	</table>
	<form name="search" method="get" action="${contextPath}/blog/myblogSearch.do">
		<input type="search" name="search" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>
</body>
</html>