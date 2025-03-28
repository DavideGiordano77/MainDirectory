const express = require('express');
const router = express.Router();
const getTop100Oscars  = require("../controllers/oscar"); // Importazione corretta

/**
 * @swagger
 * /oscars/top100:
 *     get:
 *       summary: Recupera i Top 100 Oscar con poster
 *       description: |
 *         Questo endpoint restituisce i primi 100 vincitori degli Oscar con informazioni sui film, inclusi titolo, anno e poster (se disponibili).
 *       tags:
 *         - Oscars
 *       responses:
 *         "200":
 *           description: Lista dei Top 100 Oscar con dettagli sui film.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   groupedAwards:
 *                     type: object
 *                     additionalProperties:
 *                       type: array
 *                       items:
 *                         type: object
 *                         properties:
 *                           category:
 *                             type: string
 *                             example: "Best Picture"
 *                           film:
 *                             type: string
 *                             example: "The Godfather"
 *                           yearFilm:
 *                             type: integer
 *                             example: 1972
 *                           posterUrl:
 *                             type: string
 *                             format: uri
 *                             example: "https://example.com/poster.jpg"
 *                           filmId:
 *                             type: integer
 *                             example: 12345
 *         "500":
 *           description: Errore nel recupero dei dati.
 */

// Rotta per ottenere i top 100 Oscar
router.get('/top-100', getTop100Oscars.getTop100Oscars);

module.exports = router;
