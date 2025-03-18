package com.andrianigiordano.springboot.movies;

import com.andrianigiordano.springboot.actors.Actors;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {
    @Query("SELECT DISTINCT m FROM Movies m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Movies> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query("SELECT m FROM Movies m LEFT JOIN FETCH m.poster ORDER BY m.id LIMIT 100")
    List<Movies> findAllWithPosters();

    @Query("SELECT m FROM Movies m LEFT JOIN FETCH m.poster WHERE m.id = :id")
    Optional<Movies> findMovieById(Long id);
}
