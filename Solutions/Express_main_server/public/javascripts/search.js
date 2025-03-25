document.addEventListener('DOMContentLoaded', () => {
    const movieCards = document.querySelectorAll('.movie-card');
    const actorCards = document.querySelectorAll('.actor-card');

    // Gestisce il click sulle card dei film
    movieCards.forEach(card => {
        card.addEventListener('click', () => {
            const movieId = card.getAttribute('data-id');
            if (movieId) {
                window.location.href = `/movies/get-all-info/${movieId}`;
            } else {
                console.error("ID film non trovato");
            }
        });
    });

    // Gestisce il click sulle card degli attori
    actorCards.forEach(card => {
        card.addEventListener('click', () => {
            const actorId = card.getAttribute('data-id');
            if (actorId) {
                window.location.href = `/actors/actors-info/${name}`;
            } else {
                console.error("ID attore non trovato");
            }
        });
    });
});
