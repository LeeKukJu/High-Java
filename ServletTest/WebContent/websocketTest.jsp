<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>웹소켓 사용 예제</title>
</head>
<body>
	<label for="username">접속자 이름: </label><input type="text" id="username" value="">
	<button type="button" id="connBtn" onclick="connect()">(재)연결</button>
	<button type="button" id="disconnBtn" onclick="disconnect()" disabled="disabled">접속끊기</button>
	<br>
	<hr>

    <!-- 메시지 표시 영역 -->
    <textarea id="messageTextArea" readonly="readonly" rows="10" cols="45"></textarea><br>

    <!-- 송신 메시지 텍스트박스 -->
    <input type="text" id="messageText" size="50" onkeyup="enterkey()">

    <!-- 송신 버튼 -->
    <button type="button" onclick="sendMessage()">보내기</button>

    <script>
    	
    	// 웹소켓 객체변수 선언
    	var webSocket;
    	
    	// 웹소켓 접속하기
    	function connect() {
    		const username = document.getElementById("username").value;
    		if(username.trim().length === 0){
    			alert('접속자 이름을 입력해 주세요.');
    			return;
    		}
    		
			
	        if(webSocket && webSocket.readyState !== 3){ // 기존에 연결된 소켓이 존재하면...
	        	disconnect();
	        }
	        
			
	        //웹소켓 연결(초기화) (웹소켓 URI 주소 : ws://서버주소:포트번호/컨텍스트이름(프로젝트명)/웹소켓서비스명
	        webSocket = new WebSocket("ws://127.0.0.1/Lec99ServletExam/chat");
	        
	        // 웹소켓 연결되었을때....
	        webSocket.onopen = function(evt){
	        		
	        	console.log('연결되었습니다.');
	        	
	        	// 연결끊기버튼 활성화
	        	document.getElementById("disconnBtn").disabled = false;
	        	
	        	// 접속자이름 보내기
	        	const username = document.getElementById("username");
	            webSocket.send(username.value);
	        		
	        };
	        
	       // 웹소켓에서 에러발생시...
	        webSocket.onerror = function(evt){
	        	console.log('에러발생', evt);
	        	
	        };
	        
			
	        // 웹소켓에서 메시지 도착한 경우....
	        webSocket.onmessage = function processMessge(message){
	        	
	        	 // json 데이터 파싱 
	            const jsonData = JSON.parse(message.data);
	        	 
	            if(jsonData.message != null) {
	            	
	            	displayChatMessage(jsonData.message);
	            	
	            };
		       
	        }
    	}
    	
    	// 대화창에 메시지 출력하기
    	function displayChatMessage(msg){
    		//메시지가 오면 messageTextArea요소에 메시지를 추가한다.
	        let messageTextArea = document.getElementById("messageTextArea");
    		
            messageTextArea.value += msg + "\n"
            
            // 스크롤 맨아래로 내리기
            messageTextArea.scrollTop = messageTextArea.scrollHeight;
                
    	}

    	//메시지 보내기
        function sendMessage(){
            const messageText = document.getElementById("messageText");
            webSocket.send(messageText.value);
            
            // 초기화
            messageText.value = "";
        }
    	
        // 엔터키가 눌렸을 때 메시지 보내기
        function enterkey() {
        	if (window.event.keyCode == 13) {
        		sendMessage();
            }
        }
        
     // 웹소켓 접속 끊기
    function disconnect() {
       	console.log('기존소켓 닫기'); 
       	webSocket.close(); // 기존소켓 닫기
       	
       	displayChatMessage('접속을 종료했습니다.');
       	
     	// 연결끊기버튼 비활성화
    	document.getElementById("disconnBtn").disabled = true;
    	
     }
    
    </script>
</body>
</html>