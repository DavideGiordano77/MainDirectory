const MembersReview = require('../models/members_review');

exports.getCriticDetails = async (req, res) => {
    try {
        const criticName = req.params.critic_name;

        // Trova tutte le recensioni del critico
        const reviews = await MembersReview.find({ critic_name: criticName })
            .select('movie_title review_type review_score review_date review_content');

        if (reviews.length === 0) {
            return res.status(404).json({ error: 'Critico non trovato' });
        }

        // Estrarre i dettagli dei film recensiti
        const movies = reviews.map(review => ({
            movie_title: review.movie_title,
            review_type: review.review_type,
            review_score: review.review_score,
            review_date: review.review_date,
            review_content: review.review_content
        }));

        res.status(200).json({ criticName, movies });
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};
