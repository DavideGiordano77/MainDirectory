var express = require('express');
var router = express.Router();
var homeController = require('../controllers/home');

/**
 * @swagger
 * /:
 *   get:
 *     summary: Ottieni i film della home
 *     description: Recupera l'elenco dei film dalla home page del server Spring Boot.
 *     tags:
 *       - Home
 *     responses:
 *       '200':
 *         description: Lista dei film ottenuta con successo
 *         content:
 *           application/json:
 *             schema:
 *               type: array
 *               items:
 *                 type: object
 *                 properties:
 *                   id:
 *                     type: integer
 *                     example: 1
 *                   name:
 *                     type: string
 *                     example: "Inception"
 *                   poster:
 *                     type: string
 *                     example: "https://image.tmdb.org/t/p/w500/xyz.jpg"
 *                   date:
 *                     type: integer
 *                     example: "2010"
 *                   tagline:
 *                     type: string
 *                     example: "Your mind is the scene of the crime."
 *                   description:
 *                     type: string
 *                     example: "A mind-bending thriller about dreams within dreams."
 *                   rating:
 *                     type: number
 *                     format: float
 *                     example: 8.8
 */

router.get('/', homeController.getMoviesHome);

module.exports = router;
