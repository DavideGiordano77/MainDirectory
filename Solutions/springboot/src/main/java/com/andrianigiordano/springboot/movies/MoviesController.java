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
    @GetMapping("/get-themes-by-id")
    public ResponseEntity<String> getThemesByMovieId(@RequestParam Long movieId) {
        String themes = movieService.getThemesByMovieId(movieId);
        if (themes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(themes);
    }

    @GetMapping("/get-crew-by-id")
    public ResponseEntity<String> getCrewByMovieId(@RequestParam Long movieId) {
        String crew = movieService.getCrewByMovieId(movieId);
        if (crew.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(crew);
    }

    @GetMapping("/get-genres-by-id")
    public ResponseEntity<String> getGenresByMovieId(@RequestParam Long movieId) {
        String genres = movieService.getGenresByMovieId(movieId);
        if (genres.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/get-countries-by-id")
    public ResponseEntity<String> getCountriesByMovieId(@RequestParam Long movieId) {
        String countries = movieService.getCountriesByMovieId(movieId);
        if (countries.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/get-languages-by-id")
    public ResponseEntity<String> getLanguagesByMovieId(@RequestParam Long movieId) {
        String languages = movieService.getLanguagesByMovieId(movieId);
        if (languages.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/get-studios-by-id")
    public ResponseEntity<String> getStudiosByMovieId(@RequestParam Long movieId) {
        String studios = movieService.getStudiosByMovieId(movieId);
        if (studios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studios);
    }

}
