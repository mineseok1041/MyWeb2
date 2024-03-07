<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WriteBlog Page</title>
</head>
<body>
	<form name="writeBlog" method="post" action="blog/writeBlog.do">
		<table>
			<tr>
				<td>제목</td>
				<td><input name="title" type="text" placeholder="제목" required></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="contents" cols="30" rows="5" placeholder="내용" maxlength="500" required></textarea></td>
			</tr>
		</table>
		<input type="submit" value="완료">
	</form>
</body>
</html>