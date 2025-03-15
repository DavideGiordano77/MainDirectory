package com.andrianigiordano.springboot.movies;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private final MoviesService movieService;

    public MoviesController(MoviesService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get-all")
    public List<Movies> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/get-by-id")
    public Optional<Movies> getMovieById(@RequestParam Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/search-movies")
    public List<Movies> searchMoviesByName(@RequestParam String name) {
        return movieService.searchMoviesByName(name);
    }
}
