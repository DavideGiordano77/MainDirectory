document.addEventListener('DOMContentLoaded', () => {
    const movieCards = document.querySelectorAll('.movie-card');
    const actorCards = document.querySelectorAll('.actor-card');

    movieCards.forEach(card => {
        card.addEventListener('click', () => {
            const movieId = card.getAttribute('data-id');
            if (movieId) {
                window.location.href = `/movies/get-all-info/${movieId}`;
            }
        });
    });

    actorCards.forEach(card => {
        card.addEventListener('click', () => {
            const actorId = card.getAttribute('data-id');
            if (actorId) {
                window.location.href = `/actors/actors-info/${actorName}`;
            }
        });
    });
});
