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
        res.status(500).render('pages/error', { message: 'Dati non disponibili' });
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
        const movieName = movieData.title; // Assumo che il nome del film sia memorizzato in `title`
        const releaseDate = movieData.date; // Assumiamo che la data di uscita sia in `releaseDate`

        const reviewsResponse = await AXIOS.get(`http://localhost:3001/reviews/${encodeURIComponent(movieName)}/${encodeURIComponent(releaseDate)}`);

        const data = {
            movie: movieData,
            crew: endpoints[1].data,
            countries: endpoints[2].data,
            languages: endpoints[3].data,
            genres: endpoints[4].data,
            studios: endpoints[5].data,
            themes: endpoints[6].data,
            reviews: reviewsResponse.data
        };

        console.log('Dati ricevuti:', data);
        console.log('Movie ID atteso:', movieId);

        res.render('pages/movies_info', data);

    } catch (error) {
        console.error('Error fetching data:', error);
        res.status(500).json({ error: 'Failed to fetch movie information' });
    }
}

module.exports = {
    getAllMovies,
    getAllInfo
};