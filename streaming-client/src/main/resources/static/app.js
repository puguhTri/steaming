var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('http://localhost:8185/test-imds-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {

        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/announcement_uma_widget', function (greeting) {
            xmlFeeder(JSON.parse(greeting.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/user", {}, JSON.stringify({'username': $("#name").val()}));
}

function showGreeting(message) {
console.log("ssss : " + message)
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function xmlFeeder(message) {
console.log("ssss : " + message)
    $("#xmlFeeder").append("<tr><td>" + message + "</td></tr>");
}



$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});