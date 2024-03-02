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
<link rel="stylesheet" type="text/css" href="css/viewBlog.css" />
<title>viewBlog Page</title>
</head>
<body>

<h1>${BlogDTO.title}</h1><br>
작성자: ${BlogDTO.writer} ${BlogDTO.writeDate}

<div class="contents">
	${BlogDTO.contents}
</div>


<a href="${contextPath}/blog/blogList.do">목록으로</a>

</body>
</html>