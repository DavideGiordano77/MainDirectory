const Releases = require('../models/releases');

exports.getLatestReleases = async (req, res) => {
    try {
        const latestMovies = await Releases.find().sort({ date: -1 }).limit(10);
        res.json(latestMovies);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};
