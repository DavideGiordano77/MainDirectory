package com.andrianigiordano.springboot.movies;

import com.andrianigiordano.springboot.actors.Actors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Query("SELECT DISTINCT m FROM Movies m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Movies> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query("SELECT m FROM Movies m LEFT JOIN FETCH m.poster ORDER BY m.id limit 100")
    List<Movies> findAllWithPosters();

    @Query("SELECT m FROM Movies m LEFT JOIN FETCH m.poster WHERE m.id = :id")
    Optional<Movies> findMovieById(Long id);

    @Query("SELECT distinct m FROM Movies m LEFT JOIN FETCH m.poster where m.date >= 2015")
    List<Movies> getOscarsIn2024();

    @Query("SELECT DISTINCT m FROM Movies m LEFT JOIN FETCH m.poster p WHERE m.date >= 2020")
    List<Movies> getActors();

    @Query("SELECT DISTINCT m FROM Movies m WHERE (m.name = 'Interstellar' AND m.date = 2014) " +
            "OR (m.name = 'Akira' AND m.date = 1988) " +
            "OR (m.name = 'Perfect Days' AND m.date = 2023) " +
            "OR (m.name = 'Blade Runner 2049' AND m.date = 2017) " +
            "OR (m.name = 'Shrek' AND m.date = 2001)")
    List<Movies> getAllPosters();

}
