document.addEventListener("DOMContentLoaded", function () {
    console.log("JavaScript caricato!");

    // Gestione click sui poster dei film
    const moviePosters = document.querySelectorAll(".movie-poster");

    moviePosters.forEach(poster => {
        poster.addEventListener("click", function () {
            const movieId = this.dataset.id;
            if (movieId) {
                window.location.href = `/movies/get-all-info/${movieId}`;
            }
        });
    });

    // Gestione click sui nomi degli attori
    const actorNames = document.querySelectorAll(".actor-name");

    actorNames.forEach(actor => {
        actor.addEventListener("click", function () {
            const actorName = this.dataset.name;
            if (actorName) {
                const encodedName = encodeURIComponent(actorName);
                window.location.href = `/actors/actors-info/${encodedName}`;
            }
        });
    });
});
