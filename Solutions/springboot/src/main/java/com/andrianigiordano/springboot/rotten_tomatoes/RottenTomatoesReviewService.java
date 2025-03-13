package com.andrianigiordano.springboot.rotten_tomatoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RottenTomatoesReviewService {

    private final RottenTomatoesReviewRepository rottenTomatoesReviewsRepository;

    @Autowired
    public RottenTomatoesReviewService(RottenTomatoesReviewRepository rottenTomatoesReviewsRepository) {
        this.rottenTomatoesReviewsRepository = rottenTomatoesReviewsRepository;
    }


}
