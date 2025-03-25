package com.andrianigiordano.springboot.countries;

import com.andrianigiordano.springboot.movies.MoviesService;
import com.andrianigiordano.springboot.posters.Posters;
import com.andrianigiordano.springboot.posters.PostersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @Autowired
    private CountriesService countriesService;

    public CountriesController(CountriesService countriesService) {
        this.countriesService = countriesService;
    }


}
