<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="header.jsp"></jsp:include>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/signup.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/signup.js"></script>

<title>SignUp Page</title>
</head>

<body>
	<form name="signup" method="post" action="member/signup.do" oninput="SubmitCheck()">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id" class="id"
							oninput="Idchange()"
							autoFocus
							placeholder="영문자, 숫자로 4~12자리"
							required
							pattern="^[0-9a-zA-Z]{3,12}$"></td>
							<!-- 영문자, 숫자로 3~12자리 -->
				<td><input type="button" value="중복확인" onclick="isValidID()"></td>
				<td><span id="idValidMsg"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="pw" class="pw"
				            placeholder="영문자, 숫자로 4~12자리"
							required
							pattern="^[0-9a-zA-Z*#!]{4,12}$"></td>
							<!-- 영문자, 숫자, *#!로 4~12자리 -->
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name" class="name"
				            placeholder="ex) 홍길동"
							required
							pattern="^[가-힣a-zA-Z]{1,10}$"></td>
							<!-- 한글, 영문자로 1~10자리 -->
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email" class="email"
				            placeholder="ex) test@example.com"
							required
							pattern="^[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.][a-zA-Z]{1,5}$"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" disabled value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>