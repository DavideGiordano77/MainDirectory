package com.andrianigiordano.springboot.languages;

import com.andrianigiordano.springboot.genres.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguagesRepository extends JpaRepository<Languages, Long> {

    @Query("SELECT STRING_AGG(l.language, ', ') FROM Languages l WHERE l.movie.id = :movieId")
    String findByMovieId(Long movieId);
}
