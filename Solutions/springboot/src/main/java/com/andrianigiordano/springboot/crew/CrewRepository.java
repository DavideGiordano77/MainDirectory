package com.andrianigiordano.springboot.crew;

import com.andrianigiordano.springboot.countries.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
    List<Crew> findAllById(Long movieId);

    @Query("SELECT STRING_AGG(c.name, ', ') FROM Crew c WHERE c.movie.id = :movieId")
    String findByMovieId(Long movieId);
}
