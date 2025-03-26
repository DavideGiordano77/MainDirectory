const AXIOS = require('axios');
const axios = require("axios");
const JAVA_SPRING_SERVER_URL = 'http://localhost:8080/movies';

async function getAllMovies(req, res) {
    try {
        const response = await AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-all`);
        const movies = response.data; // I dati dei film che ottieni dal server Spring
        res.render('pages/movies', { movies }); // Passi i dati alla vista Handlebars
    } catch (error) {
        console.error('Error fetching movies from Spring API:', error);
        res.status(500).json({ error: 'Failed to fetch movies' });
    }
}

async function getAllInfo(req, res) {
    try {
        const movieId = req.params.id;

        const endpoints = await Promise.all([
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-movie-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-crew-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-countries-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-languages-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-genres-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-studios-by-id?movieId=` + movieId),
            AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-themes-by-id?movieId=` + movieId)
        ]);

        const movieData = endpoints[0].data;
        const movieName = movieData.name; // Assumo che il nome del film sia memorizzato in `name`

        const reviewsResponse = await AXIOS.get(`http://localhost:3001/reviews?movieName=` + encodeURIComponent(movieName));

        const data = {
            movie: movieData,
            crew: endpoints[1].data,
            countries: endpoints[2].data,
            languages: endpoints[3].data,
            genres: endpoints[4].data,
            studios: endpoints[5].data,
            themes: endpoints[6].data,
            reviews: reviewsResponse.data // Aggiunto qui
        };


        console.log('Dati ricevuti:', data);
        console.log('Movie ID atteso:', movieId);

        // Verifica che tutti gli ID dei film corrispondano
        const allMovieIdsMatch = Object.values(data).every(entry =>
            Array.isArray(entry)
                ? entry.every(item => item.id == movieId)
                : entry.id == movieId
        );

            res.render('pages/movies_info', data);

    } catch (error) {
        console.error('Error fetching movies from Spring API:', error);
        res.status(500).json({ error: 'Failed to fetch movies' });
    }
}


module.exports = {
    getAllMovies,
    getAllInfo
};