<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>DDIT MATE</title>
<style type="text/css">
#chatArea {
	display: none;
	border: 0px solid rgb(129, 112, 91);
	padding: 5px;
	width: 430px;
	margin: 20px auto;
}

#connectArea {
	border: 1px solid rgb(192, 168, 135);
    border-radius: 5px;
    padding: 5px;
    background-color: white;
    width: 430px;
    margin: 133px 93px 7px 210px;
}

h1{
text-align:center;
margin-top:100px;
font-size:xxx-large;
}

#userId{
width:310px;
height:25px;
margin: 0px 5px 5px 17px;
}

#btn{
background-color: rgb(192, 168, 135);
border: 1px;
border-radius: 5px;
color: white;
font-size: medium;
padding:5px;
}
#messageText{
    margin: 10px 0px 5px 3px;
    /* background-color: #eee; */
    border: 1px solid rgb(129, 112, 91);
    border-radius: 5px;
    height: 23px;
    width: 360px;
    padding: 5px;
}

#messageTextArea {
	height: 450px;
	width: 409px;
	border-radius: 5px;
	padding: 15px 0 0 15px;
	word-break: break-word;
}

.text:hover{border:3px; color: #35289b;}

#newRoomName{
	height: 26px;
    border-radius: 5px;
    border: 1px solid rgb(129, 112, 91);
}
#chat-room{
margin-top:0px;
}
#chatRoom {
	display: none;
	border: 0px;
	padding: 5px;
	width: 330px;
	margin: 0px auto;
}
#chatRoomList{
margin-bottom: 10px;
height: 100px;
}
#chatRoomMemList{
margin-bottom: 10px;
height: 200px;
}
#chatRoom select {
	width: 325px;
	padding: 10px;
	margin-top: 5px;
    border-radius: 5px;
}
}

table {
	margin: 0px auto;
}
</style>
</head>
<body style="background-color: rgb(255, 236, 179);">
	<div id="" >
		<table>
			<tr>
				<td style="vertical-align: top; ">
<!-- 					<img alt="" src=".//assets/img/talk.png"> -->
					<div id="chatArea">
						<!-- 메시지 표시 영역 -->
<!-- 						<input id="messageTextArea" readonly="readonly"> -->
						<textarea id="messageTextArea" readonly="readonly"></textarea>
						<br>
						<!-- 송신 메시지 텍스트박스 -->
						<input type="text" id="messageText" class="text" placeholder="메세지를 입력하세요" size="40" onkeyup="enterKey();">
						<!-- onkeydown="sendMessage()" -->
						<!-- 송신 버튼 -->
						<input id="btn" type="button" value="전송" onclick="sendMessage()">
						<br>
						<br>
						<input type="button" id="btn" value="접속종료" onclick="closing()">
					</div>
				</td>
				<td id="chat-room">
					<div id="chatRoom">
						<input type="text" id="newRoomName"> <input id="btn" type="button" value="채팅방만들기" onclick="createRoom()">
						<br>
							채팅방 목록
						<br>
						<select id="chatRoomList" size="10"></select>
						<br>
						<input type="button" id="btn" value="채팅방 입장" onclick="chatRoomIn()">
						<br>
						<br>
						<span id="chatRoomName">전체</span> 채팅방 멤버 목록
						<br>
						<select id="chatRoomMemList" size="20"></select>
						<br>
						<input type="button" id="btn" value="채팅방 나가기" onclick="chatRoomOut()">
					</div>
				</td>
			</tr>
		</table>
		<br>
			<!-- 접속자 입력 텍스트박스 -->
<!-- 		<img alt="사진" src=".//assets/img/back2.png"> -->
		<h1>DDITALK</h1>
		<div id="connectArea">
			<input type="text" id="userId" placeholder="사용하실 ID를 입력해주세요" size="20" onkeyup="enterKey();">
			<!-- 접속 버튼 -->
			<input type="button" id="btn" value="접속하기" onclick="connectting()">
		</div>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

	<script type="text/javascript">
		var webSocket = null; // 웹소켓 변수 선언
		var messageTextArea = document.getElementById("messageTextArea");
		var messageText = document.getElementById("messageText");
		var userText = document.getElementById("userId");

		function connectting() {
			if (userText.value.trim() == "") {
				alert("접속자 ID를 입력하세요");
				userText.focus();
				return;
			}
			//웹소켓 초기화
			webSocket = new WebSocket(
					"<%= application.getInitParameter("CHAT_ADDR") %>/websocketGroupMultiChat.do");

			// 처음 접속 성공하면 
			webSocket.onopen = function onOpen(event) {
				document.getElementById("connectArea").style.display = "none";

				document.getElementById("chatRoom").style.display = "block";
				document.getElementById("chatArea").style.display = "block";
				// webSocket.send(userText.value);
				webSocket.send(createMessage("connect", "전체", userText.value));

			}

			//메시지가 오면 messageTextArea요소에 메시지를 추가한다.
			webSocket.onmessage = function processMessge(message) {
				//Json 풀기
				var jsonData = JSON.parse(message.data);
				if (jsonData.message != null) {
					messageTextArea.value += jsonData.message + "\n"
					messageTextArea.scrollTop = 9999999;
				}
				;

				// 채팅방 목록 출력하기
				if (jsonData.roomList != null) {
					var jsonRoomList = JSON.parse(jsonData.roomList);
					var selElement = document.getElementById("chatRoomList");
					var strHtml = "";
					for (var i = 0; i < jsonRoomList.length; i++) {
						strHtml += "<option value='" + jsonRoomList[i] + "'>"
								+ jsonRoomList[i] + "</option>";
					}
					selElement.innerHTML = strHtml;
				}

				if (jsonData.roomName != null) {
					document.getElementById("chatRoomName").innerHTML = jsonData.roomName;
				}

				// 채팅방 멤버 목록 출력하기
				if (jsonData.roomMemList != null) {
					var jsonRoomMemList = JSON.parse(jsonData.roomMemList);
					var selElement = document.getElementById("chatRoomMemList");
					var strHtml = "";
					for (var i = 0; i < jsonRoomMemList.length; i++) {
						strHtml += "<option value='" + jsonRoomMemList[i] + "'>"
								+ jsonRoomMemList[i] + "</option>";
					}
					selElement.innerHTML = strHtml;
				}
			}

			webSocket.onerror = function showErrorMsg(event) {
				alert("오류 : " + event.data);
			}

			webSocket.onclose = function(event) {
				messageTextArea.value = "";
				messageText.value = "";
				userText.value = "";
				document.getElementById("connectArea").style.display = "block";
				document.getElementById("chatRoom").style.display = "none";
				document.getElementById("chatArea").style.display = "none";
			}
		}

		// 메시지 구조  {"command" : "명령종류", "room" : "채팅방이름", "message" : "메시지" }
		// 명령 종류 : "create" - 채팅방 만들기, "change" - 채팅방 이동, "message" - 메시지 전송, "connect" - 처음 접속 

		//메시지 보내기
		function sendMessage() {
			if (messageText.value.trim() == "") {
				messageText.focus();
				return;
			}
			var room = document.getElementById("chatRoomName").innerHTML.trim();

			//webSocket.send('{"room" : "' + "전체" + '", "message" : "' + messageText.value + '"}' );
			webSocket.send(createMessage("message", room, messageText.value));
			messageText.value = "";
		}
		
		// 엔터 키 입력 처리
		function enterKey() {
		    if (window.event.keyCode == 13) {  // 13은 'Enter' 키의 코드값
		        sendMessage();
		        
		    }
		}

		// 채팅방 만들기
		function createRoom() {
			var newRoom = document.getElementById("newRoomName");
			if (newRoom.value == "") {
				alert("생성할 채팅방을 입력한 후 사용하세요.")
				newRoom.focus();
				return;
			}
			webSocket.send(createMessage("create", newRoom.value, null));
			newRoom.value = "";
		}

		// 채팅방 이동
		function chatRoomIn() {
			var selectRoom = document.getElementById("chatRoomList")
			if (selectRoom.selectedIndex == -1 || selectRoom.value == "") {
				alert("이동할 채팅방을 선택한 후 사용하세요.");
				return;
			}
			webSocket.send(createMessage("change", selectRoom.value, null));
		}

		// 채팅방 나가기  ==> 즉, '전체' 채팅방으로 이동
		function chatRoomOut() {
			webSocket.send(createMessage("change", "전체", null));
		}

		// 전송할 메시지를 작성하는 함수
		function createMessage(command, room, message) {
			return '{"command" : "' + command + '", "room" : "' + room
					+ '", "message" : "' + message + '"}'
		}

		function closing() {
			webSocket.close();
		}

		window.onbeforeunload = function() {
			closing();
		}
	</script>
</body>
</html>