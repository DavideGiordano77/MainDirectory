const express = require('express');
const router = express.Router();
const releasesController = require('../controllers/releases');

// GET: Recupera una release per ID
router.get('/releases/:id', releasesController.getReleaseById);

router.get('/latest-releases', releasesController.getLatestReleases);

module.exports = router;
