package com.andrianigiordano.springboot.posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface PostersRepository extends JpaRepository<Posters, String> {
    Optional<Posters> findById(String movieId);
}