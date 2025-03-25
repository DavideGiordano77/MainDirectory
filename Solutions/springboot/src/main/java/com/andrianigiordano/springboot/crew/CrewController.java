package com.andrianigiordano.springboot.crew;

import com.andrianigiordano.springboot.countries.Countries;
import com.andrianigiordano.springboot.countries.CountriesService;
import com.andrianigiordano.springboot.posters.Posters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crew")
public class CrewController {

    @Autowired
    private CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }


}
