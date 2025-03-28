var express = require('express');
var router = express.Router();
const MEMBERS_REVIEW_CONTROLLER = require("../controllers/members_review")

/**
 * @swagger
 * /members:
 *     get:
 *       summary: Recupera l'elenco dei membri
 *       description: Restituisce una lista di membri registrati nel database.
 *       tags:
 *         - Members
 *       responses:
 *         "200":
 *           description: Lista dei membri recuperata con successo.
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
 *                     name:
 *                       type: string
 *                       example: "John Doe"
 *         "500":
 *           description: Errore nel recupero dei membri.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   error:
 *                     type: string
 *                     example: "Errore interno del server."
 */
router.get('/members', async (req, res, next) => {
  try {
    const results = await MEMBERS_REVIEW_CONTROLLER.getMembers(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

/**
 * @swagger
 * /members/{critic_name}:
 *     get:
 *       summary: Recupera i dettagli di un critico
 *       description: Restituisce informazioni dettagliate su un critico specifico.
 *       tags:
 *         - Members
 *       parameters:
 *         - name: critic_name
 *           in: path
 *           required: true
 *           description: Il nome del critico di cui recuperare i dettagli.
 *           schema:
 *             type: string
 *             example: "Roger Ebert"
 *       responses:
 *         "200":
 *           description: Dettagli del critico recuperati con successo.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   name:
 *                     type: string
 *                     example: "Roger Ebert"
 *                   reviews:
 *                     type: array
 *                     items:
 *                       type: object
 *                       properties:
 *                         movie:
 *                           type: string
 *                           example: "The Dark Knight"
 *                         rating:
 *                           type: number
 *                           example: 9.5
 *         "500":
 *           description: Errore nel recupero delle informazioni del critico.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   error:
 *                     type: string
 *                     example: "Errore interno del server."
 */
router.get('/members/:critic_name', async (req, res, next) => {
  try {
    const results = await MEMBERS_REVIEW_CONTROLLER.getCriticDetails(req, res);
    res.json(results);
  } catch (error) {
    res.status(500).json({ error: error.message });
  }
});

/**
 * @swagger
 * /reviews/{movieName}/{releaseDate}:
 *     get:
 *       summary: Recupera le recensioni di un film
 *       description: Restituisce le recensioni associate a un film specifico.
 *       tags:
 *         - Reviews
 *       parameters:
 *         - name: movieName
 *           in: path
 *           required: true
 *           description: Il nome del film da cercare.
 *           schema:
 *             type: string
 *             example: "Inception"
 *         - name: releaseDate
 *           in: path
 *           required: true
 *           description: La data di uscita del film.
 *           schema:
 *             type: string
 *             format: date
 *             example: "2010-07-16"
 *       responses:
 *         "200":
 *           description: Recensioni del film recuperate con successo.
 *           content:
 *             application/json:
 *               schema:
 *                 type: array
 *                 items:
 *                   type: object
 *                   properties:
 *                     critic:
 *                       type: string
 *                       example: "Roger Ebert"
 *                     review:
 *                       type: string
 *                       example: "Un capolavoro della cinematografia moderna."
 *                     rating:
 *                       type: number
 *                       example: 9.5
 *         "404":
 *           description: Nessuna recensione trovata per il film specificato.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   error:
 *                     type: string
 *                     example: "Recensioni non trovate per il film specificato."
 */
router.get('/reviews/:movieName/:releaseDate', async (req, res) => {
  const { movieName, releaseDate } = req.params;
  const result = await MEMBERS_REVIEW_CONTROLLER.getReviewsByMovie(movieName, releaseDate);
  res.status(result.status).json(result.data);
});

/**
 * @swagger
 * /reviews/add:
 *     post:
 *       summary: Aggiungi una recensione
 *       description: Permette di aggiungere una nuova recensione per un film.
 *       tags:
 *         - Reviews
 *       requestBody:
 *         required: true
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 movieName:
 *                   type: string
 *                   example: "The Matrix"
 *                 releaseDate:
 *                   type: string
 *                   format: date
 *                   example: "1999-03-31"
 *                 critic:
 *                   type: string
 *                   example: "John Doe"
 *                 review:
 *                   type: string
 *                   example: "Un film che ha cambiato la storia del cinema!"
 *                 rating:
 *                   type: number
 *                   example: 9.0
 *       responses:
 *         "201":
 *           description: Recensione aggiunta con successo.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   message:
 *                     type: string
 *                     example: "Recensione aggiunta con successo."
 *         "400":
 *           description: Richiesta non valida (dati mancanti o errati).
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   error:
 *                     type: string
 *                     example: "Dati della recensione non validi."
 *         "500":
 *           description: Errore durante l'aggiunta della recensione.
 *           content:
 *             application/json:
 *               schema:
 *                 type: object
 *                 properties:
 *                   error:
 *                     type: string
 *                     example: "Errore interno del server."
 */
router.post('/reviews/add', MEMBERS_REVIEW_CONTROLLER.addReview);

module.exports = router;
