package com.andrianigiordano.springboot.themes;

import com.andrianigiordano.springboot.studios.Studios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThemesRepository extends JpaRepository<Themes, Long> {

    @Query("SELECT STRING_AGG(t.theme, ', ') FROM Themes t WHERE t.movie.id = :movieId")
    String findByMovieId(Long movieId);

}
