package com.andrianigiordano.springboot.genres;

import jakarta.persistence.*;

@Entity
@Table(name = "genres_data")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private String genre;

    public Genres() {
    }

    public Genres(String genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
