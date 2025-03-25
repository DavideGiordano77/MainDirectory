package com.andrianigiordano.springboot.studios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudiosRepository extends JpaRepository<Studios, Long> {

    @Query("SELECT STRING_AGG(s.studio, ', ') FROM Studios s WHERE s.movie.id = :movieId")
    String findByMovieId(Long movieId);
}
