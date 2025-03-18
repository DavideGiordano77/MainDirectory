const express = require('express');
const router = express.Router();
const membersReviewsController = require('../controllers/members_review');


// GET: Recupera i membri (recensioni)
router.get('/members/:critic_name', membersReviewsController.getMembers);

module.exports = router;
