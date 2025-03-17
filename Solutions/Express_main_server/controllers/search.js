const AXIOS = require('axios');

async function search(req, res) {
    const query = req.query.query;
    const type = req.query.type;  // Ottieni il tipo (movie o actor)

    try {
        let response;

        if (type === 'movie') {
            response = await AXIOS.get(`http://localhost:8080/search-movies?query=${encodeURIComponent(query)}`);
        } else if (type === 'actor') {
            response = await AXIOS.get(`http://localhost:8080/search-actors?query=${encodeURIComponent(query)}`);
        } else {
            throw new Error('Tipo di ricerca non valido');
        }

        const data = response.data;

        res.render('pages/search', {
            actors: data.actors || [],
            movies: data.movies || [],
            query
        });
    } catch (error) {
        console.error('Errore durante la ricerca:', error);
        res.render('pages/search', { actors: [], movies: [], query, error: 'Errore durante la ricerca.' });
    }
}

module.exports = { search };
