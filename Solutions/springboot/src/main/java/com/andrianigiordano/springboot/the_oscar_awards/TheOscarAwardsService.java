package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return theOscarAwardsRepository.findTheOscarAwards();
    }

}
