document.addEventListener("DOMContentLoaded", function () {

    // Seleziona tutte le card dei critici
    const criticCards = document.querySelectorAll(".critic-card");

    criticCards.forEach(card => {
        card.addEventListener("click", function () {
            // Ottieni il nome del critico dal data attribute
            const criticName = this.dataset.critic_name;

            // Assicurati che criticName non sia undefined
            if (criticName) {
                const encodedCriticName = encodeURIComponent(criticName);  // Codifica correttamente l'URL
                window.location.href = `/members/${encodedCriticName}`;  // Reindirizza alla pagina dei dettagli del critico
            } else {
                console.log("Nome critico non trovato!");
            }
        });
    });
});
