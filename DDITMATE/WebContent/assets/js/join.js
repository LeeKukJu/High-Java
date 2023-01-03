/**
 * 비밀번호 확인이 비밀번호 입력과 다르면 경고메세지 출력
 */
function checkPasswordMatch() {
	var password = document.getElementsByName("memPw")[0].value;
	var confirmPassword = document.getElementsByName("memPwConfirm")[0].value;
	if (password != confirmPassword) {
		document.getElementById("errorMessage").innerHTML = "비밀번호가 다릅니다!";
	} else {
		document.getElementById("errorMessage").innerHTML = "";
	}
}
