package com.andrianigiordano.springboot.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/posters")
public class PosterController {

    @Autowired
    private PostersService postersService;

    @GetMapping("/{movieId}")
    public ResponseEntity<Posters> getPoster(@PathVariable String movieId) {
        Optional<Posters> poster = postersService.getPosterByMovieId(movieId);
        return poster.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

}