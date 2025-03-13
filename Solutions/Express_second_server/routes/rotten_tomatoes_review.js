const express = require('express');
const router = express.Router();
const rottenReviewsController = require('../controllers/rotten_tomatoes_review');

// GET: Recupera recensioni con score tra 8 e 10
router.get('/reviews/score', rottenReviewsController.getReviewsByScore);

module.exports = router;
