const express = require('express');
const router = express.Router();
const getTop100Oscars  = require("../controllers/oscar"); // Importazione corretta

// Rotta per ottenere i top 100 Oscar
router.get('/top-100', getTop100Oscars.getTop100Oscars);

module.exports = router;
