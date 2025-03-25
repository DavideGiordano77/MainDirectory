package com.andrianigiordano.springboot.genres;

import com.andrianigiordano.springboot.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name = "genres_data")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movies movie;

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
