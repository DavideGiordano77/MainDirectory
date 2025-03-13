package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheOscarAwardsService {

    private final TheOscarAwardsRepository theOscarAwardsRepository;

    @Autowired
    public TheOscarAwardsService(TheOscarAwardsRepository theOscarAwardsRepository) {
        this.theOscarAwardsRepository = theOscarAwardsRepository;
    }

}
