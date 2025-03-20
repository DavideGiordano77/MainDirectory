package com.andrianigiordano.springboot.actors;

import com.andrianigiordano.springboot.movies.Movies;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;



@Service
public class ActorsService {

    private final ActorsRepository actorsRepository;

    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public List<Actors> getAllActors() {
        return actorsRepository.findActorsForHome();
    }

    public List<Actors> searchActorsByName(String query) {
        PageRequest pageable = PageRequest.of(0, 100); // Offset 0, massimo 100 risultati
        return actorsRepository.findByNameContainingIgnoreCase(query, pageable);
    }

    public List<Actors> getActorByName(String name) {
        return actorsRepository.findActorByName(name);
    }

}
