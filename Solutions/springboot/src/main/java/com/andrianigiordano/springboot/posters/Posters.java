package com.andrianigiordano.springboot.posters;

import jakarta.persistence.*;

@Entity
@Table(name = "posters")
public class Posters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link", nullable = false)
    private String link;

    public Posters() {
    }

    public Posters(String link) {
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
