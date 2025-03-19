var express = require('express');
var router = express.Router();
const MEMBERS_REVIEW_CONTROLLER = require("../controllers/members_review")

router.get('/', function(req, res, next) {
  const locals = {
    title: 'Films APP',
    description: 'Simple Website created for movies fans'
  }
  res.render('index', { locals });

});


router.get('/members', async (req, res, next) => {
  try {
    const results = await MEMBERS_REVIEW_CONTROLLER.getMembers(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

router.get('/members/:critic_name', async (req, res, next) => {
  try {
    const results = await MEMBERS_REVIEW_CONTROLLER.getCriticDetails(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});


// Esportiamo il router
module.exports = router;
