package com.andrianigiordano.springboot.themes;

import com.andrianigiordano.springboot.movies.Movies;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "themes_data")
public class Themes {

    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movies movie;

    @Column(name = "theme") // Altri campi relativi ai temi
    private String theme;

    public Themes() {
    }

    public Themes(String theme) {
        this.theme = theme;
    }

    public Long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }
}
