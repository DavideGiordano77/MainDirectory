const express = require('express');
const router = express.Router();
const searchController = require('../controllers/search');


/**
 * @swagger
 * /search:
 *     get:
 *       summary: Cerca film o attori
 *       description: Questo endpoint permette di cercare film o attori in base a una query testuale.
 *       tags:
 *         - Search
 *       parameters:
 *         - name: query
 *           in: query
 *           required: true
 *           description: Il testo da cercare.
 *           schema:
 *             type: string
 *             example: "Leonardo DiCaprio"
 *         - name: type
 *           in: query
 *           required: true
 *           description: Specifica se la ricerca riguarda un film o un attore.
 *           schema:
 *             type: string
 *             enum: [movie, actor]
 *             example: "movie"
 *       responses:
 *         "200":
 *           description: Risultati della ricerca.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   movies:
 *                     type: array
 *                     items:
 *                       type: object
 *                       properties:
 *                         id:
 *                           type: integer
 *                           example: 12345
 *                         title:
 *                           type: string
 *                           example: "Inception"
 *                         year:
 *                           type: integer
 *                           example: 2010
 *                         posterUrl:
 *                           type: string
 *                           format: uri
 *                           example: "https://example.com/inception.jpg"
 *                   actors:
 *                     type: array
 *                     items:
 *                       type: object
 *                       properties:
 *                         id:
 *                           type: integer
 *                           example: 6789
 *                         name:
 *                           type: string
 *                           example: "Leonardo DiCaprio"
 *                         birthYear:
 *                           type: integer
 *                           example: 1974
 *         "400":
 *           description: Tipo di ricerca non valido.
 *         "500":
 *           description: Errore nel recupero dei dati.
 * */
router.get('/', searchController.search); // Unica rotta per gestire sia attori che film

module.exports = router;
