const AXIOS = require('axios');
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
        const response = await AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-movie-by-id?movieId=` + movieId);
        const movies = response.data; // I dati dei film che ottieni dal server Spring
        res.render('pages/movies_info', { movie: movies }); // Ora la vista riceve "movie"
    } catch (error) {
        console.error('Error fetching movies from Spring API:', error);
        res.status(500).json({ error: 'Failed to fetch movies' });
    }
}

module.exports = {
    getAllMovies,
    getAllInfo
};