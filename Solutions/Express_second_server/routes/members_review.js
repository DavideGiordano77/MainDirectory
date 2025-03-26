const express = require('express');
const router = express.Router();
const membersReviewsController = require('../controllers/members_review');


// GET: Recupera i membri (recensioni)

router.get('/members', membersReviewsController.getMembers);


router.get('/members/:critic_name', membersReviewsController.getCriticDetails);


router.get('/reviews/:movieName/:releaseDate', membersReviewsController.getReviewsByMovie);


router.post('/reviews/add', membersReviewsController.addReview);


module.exports = router;
