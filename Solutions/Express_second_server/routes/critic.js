const express = require('express');
const router = express.Router();
const membersReviewsController = require('../controllers/critic');


// GET: Recupera i membri (recensioni)
router.get('/members', membersReviewsController.getCriticDetails);

module.exports = router;
