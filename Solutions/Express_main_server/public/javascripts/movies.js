document.addEventListener("DOMContentLoaded", function () {
    console.log("JavaScript caricato!");

    // Seleziona tutti i poster dei film
    const moviePosters = document.querySelectorAll(".movie-poster");

    moviePosters.forEach(poster => {
        poster.addEventListener("click", function () {
            const movieId = this.dataset.id; // Prende l'ID del film dal data attribute
            window.location.href = `/movies/get-all-info/${movieId}`; // Reindirizza alla pagina dei dettagli
        });
    });
});
