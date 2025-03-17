package com.andrianigiordano.springboot.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository movieRepository;

    public List<MovieDTO> getAllMoviesWithPosters() {
        return movieRepository.findAllWithPosters()
                .stream()
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getName(),
                        movie.getDate(),
                        movie.getTagline(),
                        movie.getDescription(),
                        movie.getPosterUrl(), // Controlla che venga passato correttamente
                        movie.getRating(),
                        movie.getMinute()
                ))
                .collect(Collectors.toList());
    }


    public Optional<Movies> getMovieById(Long id) {
        return movieRepository.  findById(id);
    }

    public List<Movies> searchMoviesByName(String name) {
        return movieRepository.findByNameContainingIgnoreCase(name);
    }

}
