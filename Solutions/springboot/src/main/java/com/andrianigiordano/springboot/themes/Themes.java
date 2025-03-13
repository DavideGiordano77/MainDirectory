package com.andrianigiordano.springboot.themes;

import jakarta.persistence.*;

@Entity
@Table(name = "themes_data")
public class Themes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme", nullable = false)
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
