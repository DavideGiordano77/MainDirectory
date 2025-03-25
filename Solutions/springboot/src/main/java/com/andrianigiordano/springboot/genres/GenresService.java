package com.andrianigiordano.springboot.genres;

import com.andrianigiordano.springboot.crew.Crew;
import com.andrianigiordano.springboot.crew.CrewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenresService {

    @Autowired
    private GenresRepository genresRepository;


}
