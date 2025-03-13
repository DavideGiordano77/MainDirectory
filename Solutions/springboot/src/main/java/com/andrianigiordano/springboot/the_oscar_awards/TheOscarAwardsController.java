package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oscar-awards")
public class TheOscarAwardsController {

    private final TheOscarAwardsService theOscarAwardsService;

    @Autowired
    public TheOscarAwardsController(TheOscarAwardsService theOscarAwardsService) {
        this.theOscarAwardsService = theOscarAwardsService;
    }

}
