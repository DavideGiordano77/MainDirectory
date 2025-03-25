package com.andrianigiordano.springboot.languages;

import com.andrianigiordano.springboot.countries.Countries;
import com.andrianigiordano.springboot.countries.CountriesService;
import com.andrianigiordano.springboot.crew.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/languages")
public class LanguagesController {

    @Autowired
    private LanguagesService languagesService;

    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }


}
