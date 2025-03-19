package com.andrianigiordano.springboot.the_oscar_awards;

import jakarta.persistence.*;

@Entity
@Table(name = "the_oscar_awards_data")
public class TheOscarAwards {

    @Column(name = "year_film", nullable = false)
    private int yearFilm;

    @Column(name = "year_ceremony", nullable = false)
    private Integer yearCeremony;

    @Column(name = "ceremony", nullable = false)
    private Integer ceremony;

    @Column(name = "category", nullable = false)
    private String category;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "film", nullable = false)
    private String film_name;

    @Column(name = "winner", nullable = false)
    private Boolean winner;

    public TheOscarAwards() {
    }

    public TheOscarAwards(int yearFilm, Integer yearCeremony, Integer ceremony, String category, String name, String film, Boolean winner) {
        this.yearFilm = yearFilm;
        this.yearCeremony = yearCeremony;
        this.ceremony = ceremony;
        this.category = category;
        this.name = name;
        this.film_name = film;
        this.winner = winner;
    }

    public int getYearFilm() {
        return yearFilm;
    }

    public void setYearFilm(int yearFilm) {
        this.yearFilm = yearFilm;
    }

    public Integer getYearCeremony() {
        return yearCeremony;
    }

    public void setYearCeremony(Integer yearCeremony) {
        this.yearCeremony = yearCeremony;
    }

    public Integer getCeremony() {
        return ceremony;
    }

    public void setCeremony(Integer ceremony) {
        this.ceremony = ceremony;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film_name;
    }

    public void setFilm(String film) {
        this.film_name = film;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
