package com.andrianigiordano.springboot.themes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/themes")
public class ThemesController {

    private final ThemesService themesService;

    @Autowired
    public ThemesController(ThemesService themesService) {
        this.themesService = themesService;
    }


}
