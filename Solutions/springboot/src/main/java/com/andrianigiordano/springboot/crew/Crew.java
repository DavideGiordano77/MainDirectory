package com.andrianigiordano.springboot.crew;

import com.andrianigiordano.springboot.movies.Movies;
import jakarta.persistence.*;

@Entity
@Table(name = "crew_data")
public class Crew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movies movie;

    public Crew() {
    }

    public Crew(String role, String name) {
        this.role = role;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
