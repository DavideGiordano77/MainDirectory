package com.andrianigiordano.springboot.actors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {
    List<Actors> findByNameContainingIgnoreCase(String name);
}
