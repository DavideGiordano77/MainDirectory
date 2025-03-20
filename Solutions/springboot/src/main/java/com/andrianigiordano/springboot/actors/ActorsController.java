package com.andrianigiordano.springboot.actors;

import com.andrianigiordano.springboot.movies.MovieDTO;
import com.andrianigiordano.springboot.movies.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/actors")
public class ActorsController {

    private final ActorsService actorsService;

    @Autowired
    public ActorsController(ActorsService actorsService) {
        this.actorsService = actorsService;
    }

    @GetMapping("/get-all")
    public List<Actors> getAllActors() {
        return actorsService.getAllActors();
    }

    @GetMapping("/get-actor-by-name")
    public List<Actors> getMovieDetails(@RequestParam String name) {
        return actorsService.getActorByName(name);
    }

}
