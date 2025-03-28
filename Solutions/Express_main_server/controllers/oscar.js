// Endpoint del server Spring Boot
const SPRING_BOOT_API = 'http://localhost:8080/oscar';
const axios = require("axios");

async function getTop100Oscars(req, res) {
    try {

        const [oscarResponse, moviesResponse] = await Promise.all([
            axios.get(`${SPRING_BOOT_API}/top100`),
            axios.get(`http://localhost:8080/movies/top100`)
        ]);

        // Estrarre i dati dalle risposte
        const oscarAwards = oscarResponse.data;
        const movies = moviesResponse.data;

        const enrichedAwards = oscarAwards
            .map(award => {
                const movieDetails = movies.find(movie => movie.title === award.film && movie.date === award.yearFilm);
                return movieDetails && movieDetails.posterUrl ? {
                    ...award,
                    posterUrl: movieDetails.posterUrl,
                    filmId: movieDetails.id
                } : null; // Se non ha un poster, restituisce null
            })
            .filter(award => award !== null); // Rimuove i film senza poster

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
