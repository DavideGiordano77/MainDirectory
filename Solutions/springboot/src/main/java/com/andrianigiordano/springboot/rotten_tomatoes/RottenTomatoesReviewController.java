package com.andrianigiordano.springboot.rotten_tomatoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rotten-tomatoes-reviews")
public class RottenTomatoesReviewController {

    private final RottenTomatoesReviewService rottenTomatoesReviewsService;

    @Autowired
    public RottenTomatoesReviewController(RottenTomatoesReviewService rottenTomatoesReviewService) {
        this.rottenTomatoesReviewsService = rottenTomatoesReviewService;
    }

}
