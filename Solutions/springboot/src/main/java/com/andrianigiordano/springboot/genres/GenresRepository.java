package com.andrianigiordano.springboot.genres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenresRepository extends JpaRepository<Genres, Long> {

    @Query("SELECT STRING_AGG(g.genre, ', ') FROM Genres g WHERE g.movie.id = :movieId")
    String findByMovieId(Long movieId);
}
