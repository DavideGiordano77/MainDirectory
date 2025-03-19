package com.andrianigiordano.springboot.actors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.net.ContentHandler;
import java.util.Collection;
import java.util.List;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

    @Query("SELECT a FROM Actors a ORDER BY a.name ASC LIMIT 100")
    List<Actors> findFirst100Actors();

    @Query("SELECT DISTINCT a FROM Actors a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Actors> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Query("SELECT distinct a FROM Actors a where a.name = 'Ryan Gosling'")
    List<Actors> findDistinctRyanGosling(PageRequest pageable);

    @Query("SELECT distinct a FROM Actors a where a.name = 'Tobey Maguire'")
    List<Actors> findDistinctTobeyMaguire(PageRequest pageable);

    @Query("SELECT distinct a FROM Actors a where a.name = 'Natalie Portman'")
    List<Actors> findDistinctNataliePortman(PageRequest pageable);
}
