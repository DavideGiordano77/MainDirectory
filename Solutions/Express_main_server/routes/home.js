var express = require('express');
var router = express.Router();
var homeController = require('../controllers/home');

// Route per la home dei film
router.get('/', homeController.getMoviesHome);

module.exports = router;
