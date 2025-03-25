const AXIOS = require('axios');

async function search(req, res) {
    const query = req.query.query;
    const type = req.query.type;  // Ottieni il tipo di ricerca (movie o actor)

    try {
        let movies = [];
        let actors = [];

        if (type === 'movie') {
            // Se l'utente cerca un film
            const response = await AXIOS.get(`http://localhost:8080/search-movies?query=${encodeURIComponent(query)}`);
            movies = response.data.movies || [];  // Assegna i film, evitando undefined
            return res.render('pages/search-movies', { movies, query }); // Renderizza solo film
        }

        if (type === 'actor') {
            // Se l'utente cerca un attore
            const first_response = await AXIOS.get(`http://localhost:8080/search-actors?query=${encodeURIComponent(query)}`);

            if (Array.isArray(first_response.data.actors)) {
                actors = first_response.data.actors;  // Salviamo gli attori trovati
                const actorIds = actors.map(actor => actor.id);  // Estrai gli ID degli attori

                const actorDetailsPromises = actorIds.map(async id => {
                    try {
                        console.log('Richiesta per film dell\'attore con ID:', id);
                        const res = await AXIOS.get(`http://localhost:8080/movies/get-movie-by-id?movieId=${id}`);
                        return res.data;  // Restituisci i dati validi
                    } catch (error) {
                        if (error.response && error.response.status === 404) {
                            console.log(`Film non trovato per l'ID attore ${id}, salto la ricerca`);
                            return null;  // Ignora gli errori 404 e continua
                        } else {
                            console.error('Errore inaspettato:', error);
                            return null;
                        }
                    }
                });

                // Recupera i film legati agli attori
                const moviesResults = await Promise.all(actorDetailsPromises);
                movies = moviesResults.filter(item => item !== null); // Rimuovi i null
            } else {
                console.error("La proprietà 'actors' non è un array:", first_response.data.actors);
            }

            console.log(actors)
            return res.render('pages/search-actors', { actors, movies, query }); // Renderizza solo attori
        }

        throw new Error('Tipo di ricerca non valido');

    } catch (error) {
        console.error('Errore durante la ricerca:', error);
        res.render('pages/error', { query, error: 'Errore durante la ricerca.' });
    }
}


module.exports = { search };
