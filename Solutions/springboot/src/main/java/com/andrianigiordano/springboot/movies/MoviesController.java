package com.andrianigiordano.springboot.movies;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final MoviesService movieService;

    public MoviesController(MoviesService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MovieDTO>> getMoviesWithPosters() {
        return ResponseEntity.ok(movieService.getAllMoviesWithPosters());
    }

    @GetMapping("/get-movie-by-id")
    public ResponseEntity<MovieDTO> getMovieDetails(@RequestParam Long movieId) {
        return movieService.getMovieById(movieId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @GetMapping("/search-movies")
    public List<Movies> searchMoviesByName(@RequestParam String name) {
        return movieService.searchMoviesByName(name);
    }

    @GetMapping("/top100")
    public List<MovieDTO> oscarsTop100() {
        return movieService.oscarsTop100();
    }

    @GetMapping("/actors-home")
    public List<MovieDTO> getActorsHome() {
        return movieService.getActors();
    }
    @GetMapping("/get-home-movies")
    public List<MovieDTO> getHomeMovies() {
        return movieService.getPosters();
    }
}
