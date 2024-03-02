function SubmitCheck() {
	document.signup.submit.disabled = !document.forms.signup.checkValidity();
}

function isValidID() {
	$.ajax({
		url: "member/isValidID.do",
		type: "post",
		async: false,
		dataType: "text",
		data: {
			id: $("#id").val()
		},
		success: function(data) {
			if (data === "valid") {
				$("#idValidMsg").html("사용가능한 아이디입니다");
			} else if (data === "invalid") {
				$("#idValidMsg").html("이미 사용중인 아이디입니다");
			}
		}
	});
}