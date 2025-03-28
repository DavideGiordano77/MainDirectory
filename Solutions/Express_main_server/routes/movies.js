const express = require('express');
const router = express.Router();
const MOVIES_CONTROLLER= require('../controllers/movies');

/**
 * @swagger
 * /movies/get-all-movies:
 *     get:
 *       summary: Ottiene tutti i film della Home della sezione Movies
 *       description: Recupera la lista di tutti i film disponibili.
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
 *                       type: long
 *                     name:
 *                       type: string
 *                     year:
 *                       type: int
 *                     tagline:
 *                       type: string
 *                     description:
 *                       type: string
 *                     posterUrl:
 *                       type: string
 *                     rating:
 *                       type: double
 *                     minute:
 *                       type: int
 *         "500":
 *           description: Dati non disponibili
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   message:
 *                     type: string
 */
router.get('/get-all-movies', MOVIES_CONTROLLER.getAllMovies);

/**
 * @swagger
 * /movies/get-all-info/{id}:
 *  get:
 *     summary: Ottiene tutte le informazioni su un film
 *     description: Recupera informazioni dettagliate su un film specifico, tra cui cast, generi, lingue e recensioni.
 *     tags:
 *       - Movies
 *     parameters:
 *       - name: id
 *         in: path
 *         required: true
 *         description: ID del film da recuperare
 *         schema:
 *           type: integer
 *           example: 1000004
 *     responses:
 *       "200":
 *         description: Informazioni dettagliate sul film
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 movie:
 *                   type: object
 *                   properties:
 *                     id:
 *                       type: integer
 *                     title:
 *                       type: string
 *                     date:
 *                       type: integer
 *                     tagline:
 *                       type: string
 *                     description:
 *                       type: string
 *                     posterUrl:
 *                       type: string
 *                     rating:
 *                       type: number
 *                     minute:
 *                       type: integer
 *                 crew:
 *                   type: string
 *                 countries:
 *                   type: string
 *                 languages:
 *                   type: string
 *                 genres:
 *                   type: string
 *                 studios:
 *                   type: string
 *                 themes:
 *                   type: string
 *                 reviews:
 *                   type: array
 *                   items:
 *                     type: object
 *                     properties:
 *                       id:
 *                         type: string
 *                       movie_title:
 *                         type: string
 *                       critic_name:
 *                         type: string
 *                       review_type:
 *                         type: string
 *                       review_score:
 *                         type: number
 *                       review_date:
 *                         type: string
 *                       review_content:
 *                         type: string
 *       "500":
 *         description: Dati non disponibili
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 */
router.get('/get-all-info/:id', MOVIES_CONTROLLER.getAllInfo);

module.exports = router;