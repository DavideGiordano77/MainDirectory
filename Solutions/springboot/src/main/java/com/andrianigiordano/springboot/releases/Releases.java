package com.andrianigiordano.springboot.releases;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "releases")
public class Releases {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "type")
    private String type;

    @Column(name = "rating")
    private String rating;

    public Releases() {
    }

    public Releases(String country, Date date, String type, String rating) {
        this.country = country;
        this.date = date;
        this.type = type;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
