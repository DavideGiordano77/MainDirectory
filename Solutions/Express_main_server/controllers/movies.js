const AXIOS = require('axios');
const JAVA_SPRING_SERVER_URL = 'http://localhost:8081/movies';

async function getAllMovies(req, res) {
    try {
        const response = await AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-all`);
        res.json(response.data);
    } catch (error) {
        console.error('Error fetching movies from Spring API:', error);
        res.status(500).json({ error: 'Failed to fetch movies' });
    }
}

async function getMovieById(req, res) {
    const movieId = req.query.id;

    try {
        const response = await AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-by-id?id=${movieId}`);
        res.json(response.data);
    } catch (error) {
        console.error('Error fetching movie by ID:', error);
        res.status(500).json({ error: 'Failed to fetch movie' });
    }
}

async function searchMovies(req, res) {
    const query = req.query.name;

    try {
        const response = await AXIOS.get(`http://localhost:8081/api/movies/search-movies?name=${encodeURIComponent(query)}`);
        const movies = response.data;

        res.render('movies', { movies });  // Render della view movies.hbs con i dati
    } catch (error) {
        console.error('Errore nella ricerca dei film:', error.response?.data || error.message);
        res.render('error', { message: 'Errore nella ricerca dei film.' });
    }
}


module.exports = {
    getAllMovies,
    getMovieById,
    searchMovies
};
