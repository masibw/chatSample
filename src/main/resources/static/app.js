
let stompClient = null;


function setConnected(connected){
	$("#connect").prop("disabled",connected);
	$("#disconnect").prop("disabled",!connected);	
}

function connect(){
	let socket= new SockJS('/chatSample');
	stompClient=Stomp.over(socket);
	stompClient.connect({},function(frame){
		setConnected(true);
		console.log('Connected:'+frame);
		getAllMessages();
		stompClient.subscribe('/topic/messages',function(message){
			showContents(message);
		});
	});
}

function disconnect(){
	if(stompClient!==null){
		stompClient.disconnect();
	}
	setConnected(false);
	console.log('disconnected');
}

function sendMessage(){
	stompClient.send("/app/message",{},JSON.stringify({'contents':$("#contents").val(),'name':$("#name").val()}));
	
}

function showContents(message){
	var name= JSON.parse(message.body).name;
	var contents=JSON.parse(message.body).contents;
	$("#messageArea").append("<tr><th>"+name+"</th><th>"+contents+"</th></tr>");
}

function getAllMessages(){
	let request=new  XMLHttpRequest();
	const URL = "http://localhost:8080/api/messages";
	request.open('GET',URL,true);
	request.responseType = 'json';
	request.onload=function(){
		let data=this.response;
		let i=0;
		console.log(data);
		for(i=0;i<data.length;i++){
			var name= data[i].name;
			var contents=data[i].contents;
			$("#messageArea").append("<tr><th>"+name+"</th><th>"+contents+"</th></tr>");
		}
		
		
	}
	
	request.send();
	
}


$(function () {
	 $("form").on('submit', function (e) {
	        e.preventDefault();
	    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});
