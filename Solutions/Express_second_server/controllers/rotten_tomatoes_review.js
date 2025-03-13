const RottenTomatoesReview = require('../models/rotten_tomatoes_review');

// GET: Recupera tutte le recensioni con review_score tra 8 e 10
exports.getReviewsByScore = async (req, res) => {
    try {
        // Filtro per le recensioni con un punteggio tra 8 e 10
        const reviews = await RottenTomatoesReview.find({
            review_score: { $gte: 8, $lte: 10 }
        });
        res.status(200).json(reviews);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};