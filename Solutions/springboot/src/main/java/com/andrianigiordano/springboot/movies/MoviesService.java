package com.andrianigiordano.springboot.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    private final MoviesRepository movieRepository;

    public MoviesService(MoviesRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movies> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movies> searchMoviesByName(String name) {
        return movieRepository.findByNameContainingIgnoreCase(name);
    }

}
