var idOk = false;
var pwOk = false;
var pwcOk = false;
var nameOk = false;
var emailOk = false;

function IDcheck() {
		var id = document.signup.id.value;
		var idExp = /^[a-zA-Z][0-9a-zA-Z]{4,12}$/; //첫글자는 영문자, 나머지는 영문자, 숫자로 4~12자리

		if (idExp.test(id)) {
			$("#idMsg").html("✔");
			idOk = true;
		} else {
			$("#idMsg").html("❌");
			idOk = false;
		}
	}
	
	function PWcheck() {
		var pw = document.signup.pw.value;
		var pwExp = /^[0-9a-zA-Z*#!]{4,12}$/; //영문자, 숫자, *#!로 4~12자리

		if (pwExp.test(pw)) {
			$("#pwMsg").html("✔");
			pwOk = true;
		} else {
		    $("#pwMsg").html("❌");
			pwOk = false;
		}
	}

	function PWCcheck() {
		var pw = document.signup.pw.value;
		var pwc = document.signup.pwc.value;

		if (pwc.length != 0 && pwc != null) {
			if (pw == pwc) {
				$("#pwcMsg").html("✔");
				pwcOk = true;
			} else {
	            $("#pwcMsg").html("❌");
				pwcOk = false;
			}
		}
	}
	
	function NAMEcheck() {
		var name = document.signup.name.value;
		var nameExp = /^[가-힣a-zA-Z]{2,5}$/; //한글, 영문자로 2~5자리

		if (nameExp.test(name)) {
			$("#nameMsg").innerHTML = "✔";
			nameOk = true;
		} else {
	        $("#nameMsg").innerHTML = "❌";
			nameOk = false;
		}
	}
	
	function EmailCheck() {
		var email = document.signup.email.value;
		var emailExp = /^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\.[a-zA-Z]{2,4}$/; //영문숫자._ @ 영문숫자._ . 영문 2~4자리

		if (emailExp.test(email)) {
			$("#emailMsg").html("✔");
			emailOk = true;
		} else {
			$("#emailMsg").html("❌");
			emailOk = false;
		}
	}
	
	function SubmitCheck() {
		if (idOk && pwOk && pwcOk && nameOk && emailOk) {
			document.signup.submit.disabled = false;
		} else {
			document.signup.submit.disabled = true;
		}
	}