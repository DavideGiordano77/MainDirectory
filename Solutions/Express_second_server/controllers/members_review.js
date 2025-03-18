const MembersReview = require('../models/members_review');

exports.getMembers = async (req, res) => {
    try {
        // Ottieni i primi 10 critici con top_critic uguale a true
        const reviews = await MembersReview.find({ top_critic: true })
            .limit(10) // Limita i risultati ai primi
            .select('critic_name'); // Seleziona solo il campo 'critic_name'

        // Estrai i nomi dei critici
        const criticNames = reviews.map(review => review.critic_name);

        res.status(200).json(criticNames);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};
