// Endpoint del server Spring Boot
const SPRING_BOOT_API = 'http://localhost:8080/oscar';
const axios = require("axios");

async function getTop100Oscars(req, res) {
    try {

        // Recupera i Top 100 Oscar
        const response = await axios.get(`${SPRING_BOOT_API}/top100`);
        const oscarAwards = response.data;

        // Recupera tutti i film con i poster
        const moviesResponse = await axios.get(`http://localhost:8080/movies/top100`);
        const movies = moviesResponse.data;

        const enrichedAwards = oscarAwards.map(award => {
            const movieDetails = movies.find(movie => movie.title === award.film & movie.date === award.yearFilm);
            return {
                ...award,
                posterUrl: movieDetails ? movieDetails.posterUrl : ''
            };
        });

        // Raggruppamento per categoria
        const groupedAwards = enrichedAwards.reduce((acc, award) => {
            const category = award.category;
            if (!acc[category]) {
                acc[category] = [];
            }
            acc[category].push(award);
            return acc;
        }, {});

        res.render('pages/oscar', { groupedAwards });
    } catch (error) {
        console.error("Errore nel recupero dei Top 100 Oscar:", error.message);
        res.render("pages/oscar", {
            oscarAwards: [],
            error: "Errore nel caricamento dei Top 100 Oscar."
        });
    }
}

module.exports = { getTop100Oscars };
