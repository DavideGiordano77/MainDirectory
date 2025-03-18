const express = require('express');
const router = express.Router();
const MOVIES_CONTROLLER= require('../controllers/movies');

//const getAllInfo = require("../controllers/movies_info");

router.get('/get-all-movies', MOVIES_CONTROLLER.getAllMovies);

router.get('/get-all-info/:id', MOVIES_CONTROLLER.getAllInfo);

module.exports = router;