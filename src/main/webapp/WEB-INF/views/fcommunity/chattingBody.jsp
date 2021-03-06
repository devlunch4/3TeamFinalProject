<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="form-group mt-2">
<div class="m-2">
	<!-- <button type="button" onclick="openSocket();">대화방 참여</button> -->
	<button class="btn btn-secondary" type="button" onclick="closeSocket();">대화방 나가기</button>

<!-- 	<button type="button" onclick="javascript:clearText();">대화내용 지우기</button> -->
</div>
<!-- Server responses get written here -->
<div class="col-12">
<div style="overflow-y:scroll; border:2px solid black; height: 500px;" id="scrollDiv" class="col-12">
<div id="messages"></div>
</div> 	 
<input type="text" id="sender" value="${S_USER.user_id}" style="display: none;"> 

<div class="form-group">
<button type="button" class="form-group float-right small p-0" onclick="send();" id="send" style="width: 30%">메세지 전송</button>
<span class="form-group text-left" style="width: 100%">
<input type="text" id="messageinput" style="width: 70%" class="small" onkeyup="enterkey();">
</span>
</div>
</div>
<!-- websocket javascript -->
</div>
<script type="text/javascript">
        var ws;
        var messages = document.getElementById("messages");
        
        $(function openSocket(){
            if(ws !== undefined && ws.readyState !== WebSocket.CLOSED ){
                writeResponse("WebSocket is already opened.");
                return;
            }
            //웹소켓 객체 만드는 코드
            ws = new WebSocket("ws://192.168.0.111/finalProject/echo.do");//아이피 주소 셋팅할것.
            
            ws.onopen = function(event){
                if(event.data === undefined){
              		return;
                }
                writeResponse(event.data);
            };
            
            ws.onmessage = function(event){
                console.log('writeResponse');
                console.log(event.data)
                writeResponse(event.data);
            };
            
            ws.onclose = function(event){
                writeResponse("대화 종료");
            }
            
        });
        
        function send(){
           // var text=document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            var text = document.getElementById("messageinput").value+","+document.getElementById("sender").value;
            ws.send(text);
            text = "";
        }
        
        function closeSocket(){
            ws.close();
            console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
        }

        function writeResponse(text){
        	var mytext = text.split(':');
        	console.log(mytext);
        	if(mytext[0] == '<나> ' ){
            messages.innerHTML += "<div style='color: blue;'>"+text+"</div>";
        	}else{
        		messages.innerHTML += "<div>"+text+"</div>";	
        	}
        	$('#scrollDiv').scrollTop($('#scrollDiv').prop('scrollHeight'));
        	$('#messageinput').val("");
        	$('#messageinput').focus();
        }

        function clearText(){
            console.log(messages.parentNode);
            messages.parentNode.removeChild(messages)
      	}
        
        $("#messageinput").keyup(function(e){if(e.keyCode == 13)  send(); });
  </script>