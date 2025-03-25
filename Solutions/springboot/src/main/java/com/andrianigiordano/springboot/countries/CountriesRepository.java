package com.andrianigiordano.springboot.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long> {

    @Query("SELECT STRING_AGG(c.country, ', ') FROM Countries c WHERE c.movie.id = :movieId")
    String findByMovieId(Long movieId);
}
