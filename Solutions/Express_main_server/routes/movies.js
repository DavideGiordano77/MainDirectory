const express = require('express');
const router = express.Router();
const { getAllMovies, getMovieById, searchMovies } = require('../controllers/movies');

router.get('/get-all-movies', getAllMovies);
router.get('/get-movie-by-id', getMovieById);
router.get('/search-movies', searchMovies);

module.exports = router;
