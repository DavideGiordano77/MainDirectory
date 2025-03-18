const axios = require('axios');
const router = require("./index");

// Rotta per ottenere i membri dal secondo server
router.get('/members', async (req, res) => {
    try {
        // Fai una richiesta al secondo server (localhost:3001)
        const response = await axios.get('http://localhost:3001/members');

        // Passa i dati ottenuti dal secondo server alla vista HBS
        res.render('pages/members', { critics: response.data });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;
