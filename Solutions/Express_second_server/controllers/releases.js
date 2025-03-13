const Releases = require('../models/releases');

// GET: Recupera una release per ID
exports.getReleaseById = async (req, res) => {
    try {
        const release = await Releases.findById(req.params.id);
        if (!release) {
            return res.status(404).json({ message: 'Release non trovata' });
        }
        res.status(200).json(release);
    } catch (error) {
        res.status(500).json({ error: error.message });
    }
};