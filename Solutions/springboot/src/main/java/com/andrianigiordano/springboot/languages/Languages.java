package com.andrianigiordano.springboot.languages;

import com.andrianigiordano.springboot.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name = "languages_data")
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movies movie;

    public Languages() {
    }

    public Languages(String type, String language) {
        this.type = type;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
