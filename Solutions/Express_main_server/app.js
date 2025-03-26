var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
var hbs = require('hbs'); // Importa Handlebars
const handlebars = require('handlebars');


var indexRouter = require('./routes/home'); // Import del router
var usersRouter = require('./routes/users');
const moviesRoutes = require('./routes/movies');
const oscarRoutes = require('./routes/oscar');
const actorsRoutes = require('./routes/actors');
const searchRoutes = require('./routes/search');
const memberRoutes = require('./routes/members');
const chatRoutes = require('./routes/chat');

var app = express();

// Register Handlebars as view engine
const {engine} = require('express-handlebars');
app.engine('hbs', engine({
  extname: '.hbs',
  defaultLayout: 'main',
  layoutsDir: path.join(__dirname, 'views/layouts'),
  partialsDir: path.join(__dirname, 'views/partials')
}));
app.set('view engine', 'hbs');
app.set('views', path.join(__dirname, 'views')); // Aggiungi questa riga per indicare la cartella delle viste
handlebars.registerHelper('split', function (input, delimiter) {
  return input ? input.split(delimiter) : [];
});


app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

// Rotte principali
app.use('/', indexRouter);
app.use('/users', usersRouter);
app.use('/movies', moviesRoutes);
app.use('/oscar', oscarRoutes);
app.use('/actors', actorsRoutes);
app.use('/search', searchRoutes);
app.use('/members', memberRoutes);
app.use('/chat', chatRoutes);

// Catch 404 e gestione errori
app.use(function(req, res, next) {
  next(createError(404));
});

app.use(function(err, req, res, next) {
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};
  res.status(err.status || 500);
  res.render('pages/error');
});

app.use(express.json());

module.exports = app;
