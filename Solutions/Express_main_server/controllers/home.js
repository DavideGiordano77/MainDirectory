const axios = require('axios');

// URL del backend Spring Boot
const JAVA_SPRING_SERVER_URL = 'http://localhost:8080/movies/get-home-movies';

// Funzione per ottenere i film con poster
exports.getMoviesHome = async (req, res) => {
    try {
        const response = await axios.get(JAVA_SPRING_SERVER_URL);
        const movies = response.data;

        // Renderizza la pagina con i film
        res.render('partials/home', { layout: 'main', movies });
    } catch (error) {
        console.error('Errore nel recupero dei film:', error);
        res.render('partials/home', { layout: 'main', movies: [] });
    }
};
