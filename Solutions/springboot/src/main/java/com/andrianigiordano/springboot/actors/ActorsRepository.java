package com.andrianigiordano.springboot.actors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

    @Query("SELECT a FROM Actors a ORDER BY a.name ASC LIMIT 100")
    List<Actors> findFirst100Actors();

    @Query("SELECT DISTINCT a FROM Actors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Actors> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

}
