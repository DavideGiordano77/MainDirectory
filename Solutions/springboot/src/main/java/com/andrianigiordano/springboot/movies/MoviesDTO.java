package com.andrianigiordano.springboot.movies;

import com.andrianigiordano.springboot.posters.Posters;

public class MoviesDTO {
    private Long id;
    private String title;
    private String description;
    private String posterUrl;

    // Costruttore
    public MoviesDTO(Movies movie, Posters poster) {
        this.id = movie.getId();
        this.title = movie.getName();
        this.description = movie.getDescription();
        this.posterUrl = (poster != null) ? poster.getLink() : null;  // Se c'è un poster, aggiungi l'URL
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
