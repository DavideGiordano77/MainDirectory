let name = null;
let roomNo = null;
let chat = io.connect('/chat');

function init() {
    document.getElementById('initial_form').classList.remove('d-none');
    document.getElementById('chat_interface').classList.add('d-none');
    initChatSocket();
}

function initChatSocket() {
    chat.on('joined', function (room, userId) {
        if (userId === name) {
            hideLoginInterface(room, userId);
        } else {
            writeOnChatHistory(`<b>${userId}</b> joined room ${room}`);
        }
    });

    chat.on('chat', function (room, userId, chatText) {
        let who = userId === name ? 'Me' : userId;
        writeOnChatHistory(`<b>${who}:</b> ${chatText}`);
    });
}

function sendChatText() {
    let chatText = document.getElementById('chat_input').value;
    if (chatText.trim() !== "") {
        chat.emit('chat', roomNo, name, chatText);
        document.getElementById('chat_input').value = "";
    }
}

function connectToRoom() {
    roomNo = document.getElementById('roomNo').value;
    name = document.getElementById('name').value || 'Guest-' + Math.floor(Math.random() * 1000);
    chat.emit('create or join', roomNo, name);
}

function writeOnChatHistory(text) {
    let history = document.getElementById('chat_history');
    let paragraph = document.createElement('p');
    paragraph.innerHTML = text;
    history.appendChild(paragraph);
    history.scrollTop = history.scrollHeight;
}

function hideLoginInterface(room, userId) {
    document.getElementById('initial_form').classList.add('d-none');
    document.getElementById('chat_interface').classList.remove('d-none');
    document.getElementById('who_you_are').innerHTML = userId;
    document.getElementById('in_room').innerHTML = room;
}
