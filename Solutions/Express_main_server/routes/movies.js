const express = require('express');
const router = express.Router();
const MOVIES_CONTROLLER= require('../controllers/movies');

/**
 * @swagger
 * /movies/get-all-movies:
 *     get:
 *       summary: Ottiene tutti i film
 *       description: Recupera la lista di tutti i film disponibili dal server Java Spring.
 *       tags:
 *         - Movies
 *       responses:
 *         "200":
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
 *                     releaseDate:
 *                       type: string
 *                       format: long
 *                       example: "2010"
 *         "500":
 *           description: Errore nel recupero dei dati
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   message:
 *                     type: string
 *                     example: "Dati non disponibili"
 */
router.get('/get-all-movies', MOVIES_CONTROLLER.getAllMovies);

/**
 * @swagger
 * /movies/get-all-info/{id}:
 *     get:
 *       summary: Ottiene tutte le informazioni su un film
 *       description: Recupera informazioni dettagliate su un film specifico, tra cui cast, generi, lingue e recensioni.
 *       tags:
 *         - Movies
 *       parameters:
 *         - name: id
 *           in: path
 *           required: true
 *           description: ID del film da recuperare
 *           schema:
 *             type: integer
 *             example: 1
 *       responses:
 *         "200":
 *           description: Informazioni dettagliate sul film
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   movie:
 *                     type: object
 *                     properties:
 *                       id:
 *                         type: integer
 *                         example: 1
 *                       title:
 *                         type: string
 *                         example: "Inception"
 *                       date:
 *                         type: string
 *                         format: date
 *                         example: "2010-07-16"
 *                   crew:
 *                     type: array
 *                     items:
 *                       type: object
 *                       properties:
 *                         name:
 *                           type: string
 *                           example: "Christopher Nolan"
 *                         role:
 *                           type: string
 *                           example: "Director"
 *                   countries:
 *                     type: array
 *                     items:
 *                       type: string
 *                       example: "USA"
 *                   languages:
 *                     type: array
 *                     items:
 *                       type: string
 *                       example: "English"
 *                   genres:
 *                     type: array
 *                     items:
 *                       type: string
 *                       example: "Sci-Fi"
 *                   studios:
 *                     type: array
 *                     items:
 *                       type: string
 *                       example: "Warner Bros."
 *                   themes:
 *                     type: array
 *                     items:
 *                       type: string
 *                       example: "Dreams"
 *                   reviews:
 *                     type: array
 *                     items:
 *                       type: object
 *                       properties:
 *                         user:
 *                           type: string
 *                           example: "JohnDoe"
 *                         rating:
 *                           type: number
 *                           example: 4.5
 *                         comment:
 *                           type: string
 *                           example: "Amazing movie!"
 *         "400":
 *           description: ID del film non valido
 *         "500":
 *           description: Errore nel recupero dei dati
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   message:
 *                     type: string
 *                     example: "Dati non disponibili"
 */
router.get('/get-all-info/:id', MOVIES_CONTROLLER.getAllInfo);

module.exports = router;