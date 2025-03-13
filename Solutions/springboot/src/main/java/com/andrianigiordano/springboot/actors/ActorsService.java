package com.andrianigiordano.springboot.actors;

import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;



@Service
public class ActorsService {

    private final ActorsRepository actorsRepository;

    public ActorsService(ActorsRepository actorsRepository) {
        this.actorsRepository = actorsRepository;
    }

    public Actors saveActor(Actors actor) {
        return actorsRepository.save(actor);
    }

    public Optional<Actors> getActorById(Long id) {
        return actorsRepository.findById(id);
    }

    public List<Actors> getAllActors() {
        return actorsRepository.findAll();
    }

    public void deleteActor(Long id) {
        actorsRepository.deleteById(id);
    }

    public List<Actors> findActorsByName(String name) {
        return actorsRepository.findByNameContainingIgnoreCase(name);
    }
}
