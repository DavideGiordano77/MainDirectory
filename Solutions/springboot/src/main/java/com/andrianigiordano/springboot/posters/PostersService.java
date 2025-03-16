package com.andrianigiordano.springboot.posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostersService {

    @Autowired
    private PostersRepository postersRepository;

    public Optional<Posters> getPosterByMovieId(String movieId) {
        return postersRepository.findById(movieId);
    }

}
