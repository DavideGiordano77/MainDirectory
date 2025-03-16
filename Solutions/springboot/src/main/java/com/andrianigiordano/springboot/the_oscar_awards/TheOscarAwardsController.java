package com.andrianigiordano.springboot.the_oscar_awards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oscar")
public class TheOscarAwardsController {

    private final TheOscarAwardsService theOscarAwardsService;

    @Autowired
    public TheOscarAwardsController(TheOscarAwardsService theOscarAwardsService) {
        this.theOscarAwardsService = theOscarAwardsService;
    }

    @GetMapping("/top100")
    public List<TheOscarAwards> getTop100Oscars() {
        // Recupera la lista dei Top 100 Oscar dal servizio
        return theOscarAwardsService.getTop100Oscars();
    }

}
