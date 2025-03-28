var express = require('express');
var router = express.Router();
var homeController = require('../controllers/home');

/**
 * @swagger
 * /:
*     get:
*       summary: Ottieni i film della home
*       description: Recupera l'elenco dei film dalla home page del server Spring Boot.
*       responses:
*         '200':
*           description: Lista dei film ottenuta con successo
*           content:
*             application/json:
*               schema:
*                 type: array
*                 items:
*                   type: object
*                   properties:
*                     id:
*                       type: integer
*                       example: 1
*                     title:
*                       type: string
*                       example: "Inception"
*                     poster:
*                       type: string
*                       example: "https://image.tmdb.org/t/p/w500/xyz.jpg"
*         '500':
*           description: Errore nel recupero dei film
*/
router.get('/', homeController.getMoviesHome);

module.exports = router;
