const express = require('express');
const router = express.Router();
const ACTORS_CONTROLLER= require('../controllers/actors');

router.get('/get-all-actors', ACTORS_CONTROLLER.getAllActors);
router.get('/actors-info/:name', ACTORS_CONTROLLER.getAllInfo)

module.exports = router;