package com.andrianigiordano.springboot.studios;

import com.andrianigiordano.springboot.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name = "studios_data")
public class Studios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio", nullable = false)
    private String studio;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movies movie;

    public Studios() {
    }

    public Studios(String studio) {
        this.studio = studio;
    }

    public Long getId() {
        return id;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}
