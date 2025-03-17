const AXIOS = require('axios');
const JAVA_SPRING_SERVER_URL = 'http://localhost:8080/actors';

async function getAllActors(req, res) {
    try {
        const response = await AXIOS.get(`${JAVA_SPRING_SERVER_URL}/get-all`);
        const actors = response.data; // I dati dei film che ottieni dal server Spring
        res.render('pages/actors', { actors }); // Passi i dati alla vista Handlebars
    } catch (error) {
        console.error('Error fetching actors from Spring API:', error);
        res.status(500).json({ error: 'Failed to fetch actors' });
    }
}

module.exports = getAllActors;