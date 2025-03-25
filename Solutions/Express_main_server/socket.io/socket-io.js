
exports.init = function(io) {

    // the chat namespace
    const chat= io
        .of('/chat')
        .on('connection', function (socket) {
            try {
                /**
                 * it creates or joins a room
                 */
                socket.on('create or join', function (room, userId) {
                    socket.join(room);
                    chat.to(room).emit('joined', room, userId);
                });

                socket.on('chat', function (room, userId, chatText) {
                    chat.to(room).emit('chat', room, userId, chatText);
                });

                socket.on('disconnect', function(){
                    console.log('someone disconnected');
                });
            } catch (e) {
            }
        });

    // the news namespace
    const news= io
        .of('/news')
        .on('connection', function (socket) {
            try {
                /**
                 * it creates or joins a room
                 */
                socket.on('create or join', function (room, userId) {
                    socket.join(room);
                    socket.broadcast.to(room).emit('joined', room, userId);
                });

                socket.on('news', function (room, userId, chatText) {
                    socket.broadcast.to(room).emit('news', room, userId, chatText);
                });

                socket.on('disconnect', function(){
                    console.log('someone disconnected');
                });
            } catch (e) {
            }
        });
}

/**
@TODO
 * Home: selezionati da noi, dimensioni, searchbar @Agne
 * Actors: layout terribile, titolo, scorrimento @Agne
 * Actors-info: layout terribile, titolo @Agne
 * Oscar: colore titolo, dimensioni e colore attori vincitori, non inserire il riferimento di chi non è attore @Agne
 * Movies: perfetta
 * Movies-info: da aggiungere le recensioni @Dade
 * Critics: migliorare la disposizione, inserire immagini, distanze @Dade
 * Critics-info: migliorare il layout + poster film @Dade
 * Search-movie: perfetta
 * Search-Actors: non funziona @Agne
 * CSS: da riordinare assolutamente @Insieme
 * Socket: da fare @Insieme
 * Riorganizzazione html @Insieme

 */