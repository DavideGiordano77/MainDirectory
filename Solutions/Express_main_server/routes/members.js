const axios = require('axios');
const express = require('express');
const router = require("./index");

router.get('/members', async (req, res) => {
    try {

        // Chiamata al secondo server per ottenere i dati dei membri
        const response = await axios.get('http://localhost:3001/members');

        // I dati ricevuti dal server
        const { topCritics, allCritics } = response.data;


        // Render della pagina con i dati ricevuti
        res.render('pages/members', {
            topCritics,  // Passa l' array dei top critics alla view
            allCritics   // Passa l' array degli altri critics alla view
        });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

// Rotta per ottenere i dettagli di un critico specifico
router.get('/members/:critic_name', async (req, res) => {
    try {
        const criticName = decodeURIComponent(req.params.critic_name);

        // Fai una richiesta al secondo server (localhost:3001) per ottenere le recensioni del critico
        const response = await axios.get(`http://localhost:3001/members/${criticName}`);

        // Passa i dati ottenuti dal secondo server alla vista HBS
        res.render('pages/critic', { criticName, movies: response.data });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
});

module.exports = router;
