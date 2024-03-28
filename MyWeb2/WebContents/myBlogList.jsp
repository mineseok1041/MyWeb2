<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="name" value="${sessionScope.name}" />
<c:set var="search" value="${requestScope.search}" />

<c:set var="page" value="${requestScope.page}" />
<c:if test="${page == null}">
	<c:set var="page" value="1" />
</c:if>
<c:if test="${page != null}">
    <fmt:parseNumber var="pageNum" value="${page}" />
</c:if>

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
	<form name="search" method="get" action="${contextPath}/blog/myBlogList.do">
		<input type="search" name="search" placeholder="검색어를 입력하세요" value="${search}">
		<input type="submit" value="검색">
	</form>
	
	<div>
		<c:if test="${pageNum+0 < 3}">
			<c:if test="${search != null}">
				<a href="${contextPath}/blog/myBlogList.do?page=1&search=${search}">prev</a>
				<a href="${contextPath}/blog/myBlogList.do?page=1&search=${search}">1</a>
				<a href="${contextPath}/blog/myBlogList.do?page=2&search=${search}">2</a>
				<a href="${contextPath}/blog/myBlogList.do?page=3&search=${search}">3</a>
				<a href="${contextPath}/blog/myBlogList.do?page=4&search=${search}">4</a>
				<a href="${contextPath}/blog/myBlogList.do?page=5&search=${search}">5</a>
			</c:if>
			<c:if test="${search == null}">
				<a href="${contextPath}/blog/myBlogList.do?page=1">prev</a>
				<a href="${contextPath}/blog/myBlogList.do?page=1">1</a>
				<a href="${contextPath}/blog/myBlogList.do?page=2">2</a>
				<a href="${contextPath}/blog/myBlogList.do?page=3">3</a>
				<a href="${contextPath}/blog/myBlogList.do?page=4">4</a>
				<a href="${contextPath}/blog/myBlogList.do?page=5">5</a>
			</c:if>
		</c:if>
		<c:if test="${pageNum+0 > 2}">
			<c:if test="${search != null}">
                <a href="${contextPath}/blog/myBlogList.do?page=1&search=${search}">prev</a>
                <a href="${contextPath}/blog/myBlogList.do?page=${pageNum-2}&search=${search}">${pageNum-2}</a>
                <a href="${contextPath}/blog/myBlogList.do?page=${pageNum-1}&search=${search}">${pageNum-1}</a>
                <a href="${contextPath}/blog/myBlogList.do?page=${pageNum+0}&search=${search}">${pageNum+0}</a>
                <a href="${contextPath}/blog/myBlogList.do?page=${pageNum+1}&search=${search}">${pageNum+1}</a>
                <a href="${contextPath}/blog/myBlogList.do?page=${pageNum+2}&search=${search}">${pageNum+2}</a>
            </c:if>
			<c:if test="${search == null}">
				<a href="${contextPath}/blog/myBlogList.do?page=1&search=${search}">prev</a>
				<a href="${contextPath}/blog/myBlogList.do?page=${pageNum-2}">${pageNum-2}</a>
				<a href="${contextPath}/blog/myBlogList.do?page=${pageNum-1}">${pageNum-1}</a>
				<a href="${contextPath}/blog/myBlogList.do?page=${pageNum+0}">${pageNum+0}</a>
				<a href="${contextPath}/blog/myBlogList.do?page=${pageNum+1}">${pageNum+1}</a>
				<a href="${contextPath}/blog/myBlogList.do?page=${pageNum+2}">${pageNum+2}</a>
			</c:if>
		</c:if>
	</div>
</body>
</html>