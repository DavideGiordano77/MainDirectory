const mongoose = require('mongoose');

const RottenTomatoesReviewSchema = new mongoose.Schema({
    rotten_tomatoes_link: { type: String, required: true },
    movie_title: { type: String, required: true, max: 200 },
    critic_name: { type: String, required: true, max: 100 },
    top_critic: { type: Boolean, required: true },
    publisher_name: { type: String, required: true, max: 100 },
    review_type: { type: String, required: true, enum: ['Fresh', 'Rotten'] },
    review_score: { type: Number, min: 0, max: 10 },
    review_date: { type: Date, required: true },
    review_content: { type: String, required: true }
});

// Virtual per ottenere l'anno della recensione
RottenTomatoesReviewSchema.virtual('reviewYear').get(function () {
    return this.review_date.getFullYear();
});

// Imposta la proprietà virtuale nei risultati JSON e Object
RottenTomatoesReviewSchema.set('toObject', { getters: true, virtuals: true });
RottenTomatoesReviewSchema.set('toJSON', { getters: true, virtuals: true });

module.exports = mongoose.model('MembersReview', RottenTomatoesReviewSchema, 'rotten_tomatoes_reviews_data');
