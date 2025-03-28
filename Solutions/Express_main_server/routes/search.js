const express = require('express');
const router = express.Router();
const searchController = require('../controllers/search');


/**
 * @swagger
 * /search:
 *   get:
 *     summary: Cerca film o attori
 *     description: Questo endpoint permette di cercare film o attori in base a una query testuale.
 *     tags:
 *       - Search
 *     parameters:
 *       - name: query
 *         in: query
 *         required: true
 *         description: Il testo da cercare.
 *         schema:
 *           type: string
 *       - name: type
 *         in: query
 *         required: true
 *         description: Specifica se la ricerca riguarda un film o un attore.
 *         schema:
 *           type: string
 *           enum: [movie, actor]
 *     responses:
 *       "200":
 *         description: Risultati della ricerca.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 movies:
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
 *                 actors:
 *                   type: array
 *                   items:
 *                     type: object
 *                     properties:
 *                       id:
 *                         type: integer
 *                       name:
 *                         type: string
 *                       role:
 *                         type: string
 *       "500":
 *         description: Errore nel recupero dei dati.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 * */
router.get('/', searchController.search); // Unica rotta per gestire sia attori che film

module.exports = router;
