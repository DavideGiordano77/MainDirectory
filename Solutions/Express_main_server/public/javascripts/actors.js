document.addEventListener("DOMContentLoaded", function () {
    console.log("JavaScript caricato!");

    // Seleziona tutti i poster dei film
    const moviePosters = document.querySelectorAll(".movie-poster");

    moviePosters.forEach(poster => {
        poster.addEventListener("click", function () {
            const movieId = this.dataset.id; // Prende l'ID del film dal data attribute
            if (movieId) {
                window.location.href = `/movies/get-all-info/${movieId}`; // Reindirizza alla pagina dei dettagli
            }
        });
    });

    // Seleziona tutti gli attori
    const actorLinks = document.querySelectorAll(".actor-link");

    actorLinks.forEach(actor => {
        actor.addEventListener("click", function () {
            const actorName = this.dataset.actor; // Prende il nome dell'attore
            if (actorName) {
                window.location.href = `/actors/actors-info/${actorName}`; // Reindirizza alla pagina dell'attore
            }
        });
    });
});
