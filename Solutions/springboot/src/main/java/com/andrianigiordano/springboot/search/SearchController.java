package com.andrianigiordano.springboot.search;

import com.andrianigiordano.springboot.actors.ActorsService;
import com.andrianigiordano.springboot.actors.Actors;
import com.andrianigiordano.springboot.movies.MoviesService;
import com.andrianigiordano.springboot.movies.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // Cambia da @Controller a @RestController
public class SearchController {

    private final ActorsService actorsService;
    private final MoviesService moviesService;

    public SearchController(ActorsService actorsService, MoviesService moviesService) {
        this.actorsService = actorsService;
        this.moviesService = moviesService;
    }

    @GetMapping("/search-actors")
    public Map<String, Object> searchActors(@RequestParam("query") String query) {
        List<Actors> actorsResults = actorsService.searchActorsByName(query);

        Map<String, Object> response = new HashMap<>();
        response.put("actors", actorsResults);
        response.put("query", query);

        return response; // Risposta JSON per l'API
    }

    @GetMapping("/search-movies")
    public Map<String, Object> searchMovies(@RequestParam("query") String query) {
        List<Movies> moviesResult = moviesService.searchMoviesByName(query);

        Map<String, Object> response = new HashMap<>();
        response.put("movies", moviesResult);
        response.put("query", query);

        return response; // Risposta JSON per l'API
    }
}
