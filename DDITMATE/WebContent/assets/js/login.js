/**
	입력하지 않고 로그인하면 경고창 뜸
 */
function validateForm(form) {
  if (!form.memId.value) {
    alert("아이디를 입력하세요.");
    return false;
  }
  if (form.memPw.value == "") {
    alert("패스워드를 입력하세요.");
    return false;
  }
}
