package com.andrianigiordano.springboot.studios;

import com.andrianigiordano.springboot.countries.CountriesService;
import com.andrianigiordano.springboot.crew.Crew;
import com.andrianigiordano.springboot.languages.Languages;
import com.andrianigiordano.springboot.languages.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/studios")
public class StudiosController {

    @Autowired
    private StudiosService studiosService;

    public StudiosController(StudiosService studiosService) {
        this.studiosService = studiosService;
    }


}
