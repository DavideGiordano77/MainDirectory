const express = require('express');
const router = express.Router();
const searchController = require('../controllers/search');

router.get('/', searchController.search); // Unica rotta per gestire sia attori che film

module.exports = router;
