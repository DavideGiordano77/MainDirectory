package com.andrianigiordano.springboot.actors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

    @Query("SELECT DISTINCT a FROM Actors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Actors> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query("SELECT distinct a FROM Actors a where (a.name = 'Ryan Gosling' or a.name = 'Scarlett Johansson' or a.name = 'Zendaya' or a.name = 'Tom Holland')")
    List<Actors> findActorsForHome();

    @Query("SELECT a FROM Actors a WHERE a.name = :name")
    List<Actors> findActorByName(@Param("name") String name);
}
