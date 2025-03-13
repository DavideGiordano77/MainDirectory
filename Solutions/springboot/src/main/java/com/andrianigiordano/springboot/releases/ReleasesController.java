package com.andrianigiordano.springboot.releases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/releases")
public class ReleasesController {

    private final ReleasesService releasesService;

    @Autowired
    public ReleasesController(ReleasesService releasesService) {
        this.releasesService = releasesService;
    }


}
