<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="loginID" value="${sessionScope.id}" />

<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewBlog Page</title>
</head>
<body>

<h2>${BlogDTO.title}</h2><br>
작성자: ${BlogDTO.writer} ${BlogDTO.writeDate}<br>
<c:if test="${loginID == BlogDTO.writerID}">
	<a href="${contextPath}/blog/updateBlogReq/${blog.blogNum}">수정</a>
	<a href="${contextPath}/blog/deleteBlog/${blog.blogNum}">삭제</a><br>
</c:if>
--------------------------------<br>

<pre>${BlogDTO.contents}</pre>

--------------------------------<br>

<a href="${contextPath}/blog/blogList.do">목록으로</a>
<c:if test="${loginID == BlogDTO.writerID}">
    <a href="${contextPath}/blog/myBlogList.do">내 블로그 목록</a>
</c:if>

</body>
</html>