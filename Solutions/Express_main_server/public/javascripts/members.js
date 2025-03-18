document.addEventListener("DOMContentLoaded", function () {
    console.log("JavaScript caricato!");

    // Seleziona tutte le card dei critici
    const criticCards = document.querySelectorAll(".critic-card");

    criticCards.forEach(card => {
        card.addEventListener("click", function () {
            const criticName = this.dataset.critic; // Prende il nome del critico dal data attribute
            window.location.href = `/members/${encodeURIComponent(criticName)}`; // Reindirizza alla pagina dei dettagli del critico
        });
    });
});
