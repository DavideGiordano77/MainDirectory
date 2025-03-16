const express = require('express');
const router = express.Router();
const getAllMovies= require('../controllers/movies');

router.get('/get-all-movies', getAllMovies);

module.exports = router;