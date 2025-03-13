package com.andrianigiordano.springboot.actors;

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

    @PostMapping("/insert")
    public ResponseEntity<Actors> insertActor(@RequestBody Actors actor) {
        Actors savedActor = actorsService.saveActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actors> getActorById(@PathVariable Long id) {
        return actorsService.getActorById(id)
                .map(actor -> new ResponseEntity<>(actor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public List<Actors> getAllActors() {
        return actorsService.getAllActors();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        actorsService.deleteActor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Actors>> searchActorsByName(@RequestParam String name) {
        List<Actors> actors = actorsService.findActorsByName(name);
        if (actors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
}
