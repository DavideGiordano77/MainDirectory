const MembersReview = require('../models/members_review');
const {all} = require("express/lib/application");

exports.getMembers = async (req, res) => {
    try {
        // Trova sia i top critic che gli altri
        const [topCritics, allCritics] = await Promise.all([
            MembersReview.find({ top_critic: true }).limit(3).select('critic_name'),
            MembersReview.find({ top_critic: false }).limit(10).select('critic_name')
        ]);

        res.status(200).json({
            topCritics: topCritics.map(review => review.critic_name),
            allCritics: allCritics.map(review => review.critic_name)
        });

    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};

exports.getCriticDetails = async (req, res) => {
    try {
        // Decodifica l'URL e sostituisci '%20' con uno spazio
        let criticName = decodeURIComponent(req.params.critic_name);
        criticName = criticName.replace(/%20/g, ' ').trim();  // Sostituisce '%20' con uno spazio

        console.log('Decoded Critic Name:', criticName);  // Stampa il nome del critico dopo la decodifica

        // Trova tutte le recensioni del critico nel database
        const reviews = await MembersReview.find({ critic_name: criticName })
            .select('movie_title review_type review_score review_date review_content');

        if (reviews.length === 0) {
            return res.status(404).json({ error: 'Critico non trovato' });
        }

        res.status(200).json({
            criticName,
            reviews: reviews.map(review => ({
                movie_title: review.movie_title,
                review_type: review.review_type,
                review_score: review.review_score,
                review_date: review.review_date,
                review_content: review.review_content
            }))
        });
    } catch (error) {
        console.error('Error fetching critic details:', error);
        res.status(500).json({ error: error.message });
    }
};

exports.getReviewsByMovie = async (movieName, releaseDate) => {
    try {
        const releaseDateObj = new Date(releaseDate);
        const releaseDateFormatted = releaseDateObj.toISOString().split('T')[0]; // "YYYY-MM-DD"

        const reviews = await MembersReview.find({
            movie_title: { $regex: new RegExp(`^${movieName}$`, 'i') },
            review_date: {
                $gte: releaseDateFormatted, // Data di rilascio o dopo
                $lte: '2025-12-31' // Un eventuale limite superiore
            }
        }).select('movie_title critic_name review_type review_score review_date review_content');

        // Se non ci sono recensioni, restituisce semplicemente un array vuoto
        return { status: 200, data: reviews || [] };

    } catch (error) {
        return { status: 500, data: { message: 'Errore nel recupero delle recensioni.', error } };
    }
};

exports.addReview = async (req, res) => {
    const {
        movie_title,
        critic_name,
        top_critic,
        publisher_name,
        review_type,
        review_score,
        review_date,
        review_content,
        rotten_tomatoes_link
    } = req.body;

    const newReview = new MembersReview({
        movie_title,
        critic_name,
        top_critic: top_critic === 'on',  // Perché un checkbox invia "on" come valore
        publisher_name,
        review_type,
        review_score,
        review_date,
        review_content,
        rotten_tomatoes_link
    });

    try {
        await newReview.save();  // Usa async/await per salvare la recensione
        res.redirect("http://localhost:3000/movies/get-all-movies");
    } catch (err) {
        console.error(err);
        res.status(500).json({ message: 'Errore nel salvataggio della recensione' });
    }
};
