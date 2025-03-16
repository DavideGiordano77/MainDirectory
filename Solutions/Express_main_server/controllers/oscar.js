const axios = require('axios');

// Endpoint del server Spring Boot
const SPRING_BOOT_API = 'http://localhost:8080/oscar';


// Controller per i Top 100 Oscar
async function getTop100Oscars (req, res)  {
    try {
        const response = await axios.get(`${SPRING_BOOT_API}/top100`);
        const oscarAwards = response.data;

        res.render("pages/oscar", {
            oscarAwards,
            top100: true // Aggiungi un flag per sapere che sono i top 100
        });
    } catch (error) {
        console.error("Errore nel recupero dei Top 100 Oscar:", error.message);
        res.render("pages/oscar", {
            layout: "layout/main",
            oscarAwards: [],
            error: "Errore nel caricamento dei Top 100 Oscar."
        });
    }
}

module.exports = getTop100Oscars;