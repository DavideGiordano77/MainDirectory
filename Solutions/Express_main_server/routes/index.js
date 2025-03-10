var express = require('express');
var router = express.Router();


/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('pages/index', { title: 'My Class' });
});
router.get('pages/welcome', function(req, res, next) {
  res.render('pages/welcome', { title: 'IUM+TWEB' });
});

module.exports = router;
