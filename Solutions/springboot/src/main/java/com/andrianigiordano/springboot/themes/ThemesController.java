package com.andrianigiordano.springboot.themes;

import com.andrianigiordano.springboot.countries.CountriesService;
import com.andrianigiordano.springboot.crew.Crew;
import com.andrianigiordano.springboot.studios.Studios;
import com.andrianigiordano.springboot.studios.StudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/themes")
public class ThemesController {

    @Autowired
    private ThemesService themesService;

    public ThemesController(ThemesService themesService) {
        this.themesService = themesService;
    }
}
