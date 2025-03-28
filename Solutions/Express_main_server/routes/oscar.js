const express = require('express');
const router = express.Router();
const getTop100Oscars  = require("../controllers/oscar"); // Importazione corretta

/**
 * @swagger
 * /oscars/top100:
 *   get:
 *     summary: Recupera i Top 100 Oscar con poster
 *     description: Questo endpoint restituisce i primi 100 vincitori degli Oscar con informazioni sui film, inclusi titolo, anno e poster (se disponibili).
 *     tags:
 *       - Oscars
 *     responses:
 *       "200":
 *         description: Lista dei Top 100 Oscar con dettagli sui film.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 groupedAwards:
 *                   type: array
 *                   items:
 *                     type: object
 *                     properties:
 *                       yearFilm:
 *                         type: integer
 *                       yearCeremony:
 *                         type: integer
 *                       ceremony:
 *                         type: integer
 *                       category:
 *                         type: string
 *                       name:
 *                         type: string
 *                       winner:
 *                         type: boolean
 *                       film:
 *                         type: string
 *                       posterUrl:
 *                         type: string
 *                       filmId:
 *                         type: integer
 *       "500":
 *         description: Errore nel recupero dei dati.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 */


// Rotta per ottenere i top 100 Oscar
router.get('/top-100', getTop100Oscars.getTop100Oscars);

module.exports = router;
