package com.andrianigiordano.springboot.studios;

import jakarta.persistence.*;

@Entity
@Table(name = "studios_data")
public class Studios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "studio", nullable = false)
    private String studio;

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
