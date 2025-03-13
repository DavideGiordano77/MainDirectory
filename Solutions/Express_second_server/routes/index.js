var express = require('express');
var router = express.Router();
const releases_controller = require("../controllers/releases")
const rotten_tomato_review_controller = require("../controllers/rotten_tomatoes_review")

// Rotta per ottenere una release per ID
router.get('/releases/:id', async (req, res, next) => {
  try {
    const results = await releases_controller.getReleaseById(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Rotta per ottenere recensioni con punteggio tra 8 e 10
router.get('/rotten_tomato_review/review_score', async (req, res, next) => {
  try {
    const results = await rotten_tomato_review_controller.getReviewsByScore(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Esportiamo il router
module.exports = router;
