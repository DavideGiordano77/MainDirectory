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

// Rotta per ottenere recensioni con punteggio tra 8 e 10
router.get('/members', async (req, res, next) => {
  try {
    const results = await MEMBERS_REVIEW_CONTROLLER.getMembers(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

// Esportiamo il router
module.exports = router;
