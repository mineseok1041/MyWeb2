<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="qcss/test.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="js/signup.js"></script>

<title>SignUp Page</title>
</head>

<body>
	<form name="signup" method="post" action="member/signup.do" oninput="SubmitCheck()">
		<table>
			<tr>
				<td>아이디</td>
				<td><span id="idMsg"></span></td>
				<td><input type="text" name="id" id="id"
							autoFocus
							placeholder="첫글자는 영문자, 나머지는 영문자, 숫자로 4~12자리"
				            onkeyup="IDcheck()"
				            oninvalid="this.setCustomValidity('아이디를 다시 입력하세요')"
							required 
							pattern="^[a-zA-Z][0-9a-zA-Z]{4,12}$"></td>
							<!-- 첫글자는 영문자, 나머지는 영문자, 숫자로 4~12자리 -->
				<td><input type="button" value="중복확인" onclick="isValidID()"></td>
				<td><span id="idValidMsg"></span></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><span id="pwMsg"></span></td>
				<td><input type="password" name="pw" id="pw"
				            placeholder="영문자, 숫자로 4~12자리"
							onkeyup="PWcheck();PWCcheck();" 
							oninvalid="this.setCustomValidity('비밀번호를 다시 입력하세요')"
							required
							pattern="^[0-9a-zA-Z*#!]{4,12}$"></td>
							<!-- 영문자, 숫자, *#!로 4~12자리 -->
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><span id="pwcMsg"></span></td>
				<td><input type="password" name="pwc" id="pwc"
				            placeholder="비밀번호와 일치해야 합니다"
							onkeyup="PWCcheck()" 
							oninvalid="this.setCustomValidity('비밀번호가 일치하지 않습니다')"
							required
							pattern="^[0-9a-zA-Z]{4,12}$"></td>
							<!-- 영문자, 숫자로 4~12자리 -->
			</tr>
			<tr>
				<td>이름</td>
				<td><span id="nameMsg"></span></td>
				<td><input type="text" name="name" id="name"
				            placeholder="ex) 홍길동"
							onkeyup="NAMEcheck()"
				            oninvalid="this.setCustomValidity('이름을 다시 입력하세요')"
							required
							pattern="^[가-힣a-zA-Z]{2,5}$"></td>
							<!-- 한글, 영문자로 2~5자리 -->
			</tr>
			<tr>
				<td>이메일</td>
				<td><span id="emailMsg"></span></td>
				<td><input type="text" name="email" id="email"
				            placeholder="ex) test@example.com"
							required
							onkeyup="EmailCheck()"
							oninvalid="this.setCustomValidity('이메일을 다시 입력하세요')"
							pattern="^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\.[a-zA-Z]{2,4}$"></td>
							<!-- 영문숫자._ @ 영문숫자._ . 영문 2~4자리 -->
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" disabled value="회원가입"></td>
			</tr>
		</table>
	</form>
</body>
</html>