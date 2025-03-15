package com.andrianigiordano.springboot.posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PostersRepository extends JpaRepository<Posters, String> {
    Optional<Posters> findByMovieId(String movieId);
}