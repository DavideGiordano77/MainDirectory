package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheOscarAwardsRepository extends JpaRepository<TheOscarAwards, Long> {
    List<TheOscarAwards> findTop100ByOrderByYearFilmDesc();  // Metodo per ottenere i top 100 Oscar
}
