package com.andrianigiordano.springboot.studios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudiosService {

    private final StudiosRepository studiosRepository;

    @Autowired
    public StudiosService(StudiosRepository studiosRepository) {
        this.studiosRepository = studiosRepository;
    }


}
