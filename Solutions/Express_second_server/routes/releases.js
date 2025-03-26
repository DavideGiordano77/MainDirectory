const express = require('express');
const router = express.Router();
const releasesController = require('../controllers/releases');

router.get('/latest-releases', releasesController.getLatestReleases);

module.exports = router;
