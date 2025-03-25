package com.andrianigiordano.springboot.genres;

import com.andrianigiordano.springboot.countries.CountriesService;
import com.andrianigiordano.springboot.crew.Crew;
import com.andrianigiordano.springboot.crew.CrewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenresController {

    @Autowired
    private GenresService genresService;

    public GenresController(GenresService genresService) {
        this.genresService = genresService;
    }

}
