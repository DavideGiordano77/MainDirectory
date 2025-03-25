const AXIOS = require('axios');
const {get} = require("axios");
const JAVA_SPRING_SERVER_URL = 'http://localhost:8080/actors';

async function getAllActors(req, res) {
    try {
        // Esegui entrambe le richieste in parallelo per ridurre il tempo di attesa
        const [actorsResponse, moviesResponse] = await Promise.all([
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-all`),
            AXIOS.get(`http://localhost:8080/movies/actors-home`)
        ]);

        const actors = actorsResponse.data; // Lista degli attori
        const movies = moviesResponse.data; // Lista dei film con poster

        // Creare una mappa filmId -> film (per accesso O(1) invece di O(n))
        const moviesMap = new Map(movies.map(movie => [movie.id, movie]));

        // Arricchisci gli attori solo se il film ha un poster
        const enrichedActors = actors
            .map(actor => {
                const movieDetails = moviesMap.get(actor.id);
                return movieDetails?.posterUrl ? {
                    ...actor,
                    posterUrl: movieDetails.posterUrl,
                    filmId: movieDetails.id
                } : null;
            })
            .filter(Boolean); // Rimuove i valori null

        // Evita i duplicati di poster
        const uniqueActors = [];
        const seenPosters = new Set();

        enrichedActors.forEach(actor => {
            if (!seenPosters.has(actor.posterUrl)) {
                uniqueActors.push(actor);
                seenPosters.add(actor.posterUrl);
            }
        });

        // Raggruppa gli attori per nome
        const groupedActors = uniqueActors.reduce((acc, actor) => {
            (acc[actor.name] ||= []).push(actor);
            acc[actor.name] = acc[actor.name].slice(0, 5); // Limita a 5 per attore
            return acc;
        }, {});


        res.render('pages/actors', {
            layout: 'main', // Aggiunto layout esplicito
            groupedActors
        });

    } catch (error) {
        console.error('Errore nel recupero dei dati:', error);
        res.status(500).send('Errore nel recupero dei dati');
    }
}

async function getAllInfo(req, res) {

    try {
        const name = req.params.name; // Se il nome è nel path

        // Esegui entrambe le richieste in parallelo per ridurre il tempo di attesa
        const [actorsResponse, moviesResponse] = await Promise.all([
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-actor-by-name?name=` + encodeURIComponent(name)),
            AXIOS.get(`http://localhost:8080/movies/actors-home`)
        ]);

        const actorsFilms = actorsResponse.data;
        const moviesData = moviesResponse.data;

        // Creare una mappa filmId -> film (per accesso O(1) invece di O(n))
        const moviesMap = new Map(moviesData.map(movie => [movie.id, movie]));

        // Arricchisci gli attori solo se il film ha un poster
        const enrichedActors = actorsFilms
            .map(actor => {
                const movieDetails = moviesMap.get(actor.id);
                return movieDetails?.posterUrl ? {
                    ...actor,
                    posterUrl: movieDetails.posterUrl,
                    filmId: movieDetails.id
                } : null;
            })
            .filter(Boolean); // Rimuove i valori null

        // Passa 'enrichedActors' al template
        res.render('pages/actors_info', {
            actor: enrichedActors ,
            name: name
        });
    } catch (error) {
        console.error("Errore nel recupero dei dettagli dell'attore:", error.message);
        res.status(500).json({ error: "Impossibile recuperare i dettagli dell'attore" });
    }

}



module.exports = {getAllActors, getAllInfo};
