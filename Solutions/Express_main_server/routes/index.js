var express = require('express');
var router = express.Router();
const app = express();

// Servire file statici (CSS, immagini, JS)
app.use(express.static('public'));

router.get('/', function(req, res, next) {
  res.render('pages/index', { layout: 'layouts/layouts' });
});

module.exports = router;
