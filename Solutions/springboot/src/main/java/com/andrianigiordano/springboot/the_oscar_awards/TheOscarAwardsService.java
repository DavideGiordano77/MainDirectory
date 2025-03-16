package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheOscarAwardsService {

    private final TheOscarAwardsRepository theOscarAwardsRepository;

    @Autowired
    public TheOscarAwardsService(TheOscarAwardsRepository theOscarAwardsRepository) {
        this.theOscarAwardsRepository = theOscarAwardsRepository;
    }

    public List<TheOscarAwards> getTop100Oscars() {
        return theOscarAwardsRepository.findTop100ByOrderByYearFilmDesc(); // Ottieni i Top 100 in ordine crescente di ID
    }

}
