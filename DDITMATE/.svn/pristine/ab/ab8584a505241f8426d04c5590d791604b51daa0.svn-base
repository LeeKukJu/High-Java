<%@page import="member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<!-- 회원정보 수정 및 회원탈퇴 jsp	 -->

<%@include file="header.jsp"%>
<%	
	String memId = (String)session.getAttribute("memId");
	System.out.println("로그인 아이디: " + memId);
	MemberVO mv = (MemberVO) request.getAttribute("mv");
	
%>
<% 
	if(memId.equals("admin")){
%>		
	<%@include file="/manager/managerSide.jsp" %>
<%
	}else {
%>
	<%@include file="memberSide.jsp" %>
<%	
	}
%>


		<!-- 회원정보수정 폼 시작 -->
				<section style="padding-bottom: 40px;">
					<div id="ddnavi" style="padding-top: 5%;">
						<h3 id="m1" style="text-align: center;">회원정보수정</h3>
					</div>
				</section>
<form action="./memChange.do" method="post">
	<section>

		<div class="container mt-3">
			<table class="table table-bordered">
				<thead>
					<tr>
						<!-- <th style="background-color: #615858;"></th> -->
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">회원아이디</td>
						<td>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext"
									value="<%=mv.getMemId() %>" aria-label="Disabled input example"
									style="width: 60%;">
							</div>
						</td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">새 비밀번호</td>
						<td><input class="form-control" type="password" name="memPw"
							placeholder="새 비밀번호를 입력해주세요" aria-label="default input example"
							style="width: 50%;"></td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">새 비밀번호
							확인</td>
						<td><input class="form-control" name="memPwConfirm" type="password"
							placeholder="새 비밀번호를 한 번 더 입력해주세요" required onkeyup="checkPasswordMatch()"
							aria-label="default input example" style="width: 50%;">
					<span id="errorMessage" class="error"></span>
					</td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">이름</td>
						<td>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext"
									value="<%=mv.getMemName() %>"
									aria-label="Disabled input example" style="width: 60%;">
							</div>
						</td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">생년월일</td>
						<td>
							<div class="col-sm-10">
								<input type="text" readonly class="form-control-plaintext"
									value="<%=mv.getMemBirth() %>"
									aria-label="Disabled input example" style="width: 60%;">
							</div>
						</td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">이메일</td>
						<td>
							<!-- <input class="form-control" type="text" placeholder="Default input" aria-label="default input example" > -->
							<input type="email" class="form-control" id="floatingInputValue"
							placeholder="이메일을 입력해주세요" name="memEmail"
							value="<%=mv.getMemEmail() %>" style="width: 50%;">
						</td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">전화번호</td>
						<td><input type="text" class="form-control"
							id="floatingInputValue" placeholder="전화번호를 입력해주세요" name="memTel"
							value="<%=mv.getMemTel() %>" style="width: 50%;"></td>
					</tr>
					<tr>
						<td class="w-25 p-3" style="background-color: #eee;">개강일</td>
						<td>
							<div class="textForm">
								<input style="margin-bottom: 5.5px;" name="memDate" type="date"
									class="classDate" id="classDate" required placeholder="개강일"
									value="<%=mv.getMemDate() %>">
							</div>
						</td>
					</tr>
				</tbody>
			</table>
			<div>
				<div>
					<p style="font-size: xx-small">
						* 회원탈퇴 후 동일아이디로 재가입이 불가합니다. &nbsp;
						<!--onclick="return confirm('정말 탈퇴하시겠습니까?')" 								<button type="button" class="btn btn-outline-primary" style="font-size: x-small;">회원탈퇴</button> -->
						<a href="./memDelete.do?memId=<%=mv.getMemId() %>" class="btn btn-outline-primary"
							id="deleteMem"
							style="font-size: x-small;"> 회원탈퇴</a>
					</p>

				</div>

				<div class="col text-center">
					<a href="/DDITMATE/member/memCheck.do">
						<button type="button" class="btn btn-outline-primary">취소</button>
					</a>
					<%-- 							<a href="<%=request.getContextPath()%>/main.jsp"> --%>
					<!-- 							</a> -->
					<input type="submit" id="updateMem" class="btn btn-primary" value="수정">
				</div>
			</div>
		</div>
<script>
function checkPasswordMatch() {
// 	required onkeyup="checkPasswordMatch()"
	var password = document.getElementsByName("memPw")[0].value;
	var confirmPassword = document.getElementsByName("memPwConfirm")[0].value;
	if (password != confirmPassword) {
		document.getElementById("errorMessage").innerHTML = "비밀번호가 일치하지 않습니다!";
	} else {
		document.getElementById("errorMessage").innerHTML = "";
	}
}

$('#deleteMem').on('click',function(){
	let deleteMem = confirm("정말 탈퇴하시겠습니까?");
	if(deleteMem == true){
		alert("탈퇴가 완료되었습니다.");
		return true;
	}else{
		return false;
	}
});
$('#updateMem').on('click',function(){
		alert("회원정보 수정이 완료되었습니다.");
});

</script>
	</section>
</form>

<!-- </form> -->
<script src="<%=application.getContextPath()%>/assets/js/sidemain.js"></script>

