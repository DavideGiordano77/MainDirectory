package com.andrianigiordano.springboot.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posters")
public class PostersController {

    private final PostersService postersService;

    @Autowired
    public PostersController(PostersService postersService) {
        this.postersService = postersService;
    }

    @GetMapping("/latest")
    public ResponseEntity<List<Posters>> findTop6ByOrderByReleaseDateDesc() {
        List<Posters> posters = postersService.getLatestPosters();
        return new ResponseEntity<>(posters, HttpStatus.OK);
    }
}
