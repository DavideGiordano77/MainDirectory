const axios = require('axios');
const router = require("./index");

// Rotta per ottenere i dettagli di un critico specifico
router.get('/members/:critic_name', async (req, res) => {
    try {
        const criticName = req.params.critic_name;

        // Fai una richiesta al secondo server (localhost:3001) per ottenere le recensioni del critico
        const response = await axios.get(`http://localhost:3001/members/${criticName}`);

        // Passa i dati ottenuti dal secondo server alla vista HBS
        res.render('pages/critic', { criticName, movies: response.data });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;
