package com.andrianigiordano.springboot.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studios")
public class StudiosController {

    private final StudiosService studiosService;

    @Autowired
    public StudiosController(StudiosService studiosService) {
        this.studiosService = studiosService;
    }

}
