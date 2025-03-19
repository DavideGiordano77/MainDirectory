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
        PageRequest pageable = PageRequest.of(0, 1); // Offset 0, massimo 100 risultati
        List<Actors> actors = new ArrayList<>();

        // Assuming 'findRyanGosling', 'findNataliePortman', and 'findTobeyMaguire' are methods that return a List or a Page
        actors.addAll(actorsRepository.findDistinctRyanGosling(pageable));
        actors.addAll(actorsRepository.findDistinctNataliePortman(pageable));
        actors.addAll(actorsRepository.findDistinctTobeyMaguire(pageable));

        return actors;
    }


    public List<Actors> searchActorsByName(String query) {
        PageRequest pageable = PageRequest.of(0, 100); // Offset 0, massimo 100 risultati
        return actorsRepository.findByNameContainingIgnoreCase(query, pageable);
    }

}
