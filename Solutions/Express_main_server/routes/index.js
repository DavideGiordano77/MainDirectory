var express = require('express');
var router = express.Router();

// Gestisce la rotta principale "/"
router.get('/', function(req, res) {
  res.render('partials/home', { layout: 'layouts/main' }); // Corretto layout
});

module.exports = router;
