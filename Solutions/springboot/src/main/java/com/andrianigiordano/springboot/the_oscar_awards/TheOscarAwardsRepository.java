package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheOscarAwardsRepository extends JpaRepository<TheOscarAwards, Long> {

    @Query("SELECT o FROM TheOscarAwards o  where o.ceremony > 90 and o.winner = true")
    List<TheOscarAwards> findTheOscarAwards();  // Metodo per ottenere i top 100 Oscar
}
