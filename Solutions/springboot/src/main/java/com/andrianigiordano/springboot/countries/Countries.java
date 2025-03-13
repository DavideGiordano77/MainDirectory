package com.andrianigiordano.springboot.countries;

import jakarta.persistence.*;

@Entity
@Table(name = "countries_data")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    public Countries() {
    }

    public Countries(String country) {
        this.country = country;
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
}
