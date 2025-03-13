const mongoose = require('mongoose');

const ReleasesSchema = new mongoose.Schema({
    country: { type: String, required: true, max: 100 },
    date: { type: Date, required: true },
    type: { type: String, required: true, max: 50 },
    rating: { type: String, required: true, max: 10 }
});

// Virtual per ottenere l'anno di rilascio
ReleasesSchema.virtual('releaseYear').get(function () {
    return this.date.getFullYear();
});

// Imposta la proprietà virtuale nei risultati JSON e Object
ReleasesSchema.set('toObject', { getters: true, virtuals: true });
ReleasesSchema.set('toJSON', { getters: true, virtuals: true });

module.exports = mongoose.model('Releases', ReleasesSchema);
