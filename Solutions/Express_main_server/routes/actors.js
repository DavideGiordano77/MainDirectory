const express = require('express');
const router = express.Router();
const getAllActors= require('../controllers/actors');

router.get('/get-all-actors', getAllActors);

module.exports = router;