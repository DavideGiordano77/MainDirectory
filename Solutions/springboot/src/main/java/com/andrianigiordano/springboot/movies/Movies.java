package com.andrianigiordano.springboot.movies;

import com.andrianigiordano.springboot.countries.Countries;
import com.andrianigiordano.springboot.crew.Crew;
import com.andrianigiordano.springboot.genres.Genres;
import com.andrianigiordano.springboot.languages.Languages;
import com.andrianigiordano.springboot.posters.Posters;
import com.andrianigiordano.springboot.studios.Studios;
import com.andrianigiordano.springboot.themes.Themes;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movies_data")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date")
    private Integer date;

    @Column(name = "tagline")
    private String tagline;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "minute")
    private Integer minute;

    @Column(name = "rating")
    private Double rating;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Posters poster;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Themes> themes;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Crew> crew;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Genres> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Languages> languages;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Studios> studios;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Countries> countries;

    public String getPosterUrl() {
        return poster != null ? poster.getLink() : null;
    }

    public Movies() {
    }

    public Movies(String name, int date, String tagline, String description, Integer minute, Double rating) {
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

}
