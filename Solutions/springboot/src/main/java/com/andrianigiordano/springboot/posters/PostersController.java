package com.andrianigiordano.springboot.posters;

import org.springframework.beans.factory.annotation.Autowired;
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

}
