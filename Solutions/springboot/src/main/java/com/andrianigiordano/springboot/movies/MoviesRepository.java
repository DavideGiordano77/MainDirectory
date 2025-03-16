package com.andrianigiordano.springboot.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    List<Movies> findByNameContainingIgnoreCase(String name);

    @Query("SELECT m FROM Movies m ORDER BY m.id ASC LIMIT 100")
    List<Movies> findFirst100Movies();
}
