package com.andrianigiordano.springboot.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
                        movie.getPosterUrl(),
                        movie.getRating(),
                        movie.getMinute()
                ))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> oscarsTop100() {
        return movieRepository.getOscarsIn2024()
                .stream()
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getName(),
                        movie.getDate(),
                        movie.getTagline(),
                        movie.getDescription(),
                        movie.getPosterUrl(),
                        movie.getRating(),
                        movie.getMinute()
                ))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> getActors() {
        return movieRepository.getActors()
                .stream()
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getName(),
                        movie.getDate(),
                        movie.getTagline(),
                        movie.getDescription(),
                        movie.getPosterUrl(),
                        movie.getRating(),
                        movie.getMinute()
                ))
                .collect(Collectors.toList());
    }


    public Optional<MovieDTO> getMovieById(Long id) {
        return movieRepository.findMovieById(id)
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getName(),
                        movie.getDate(),
                        movie.getTagline(),
                        movie.getDescription(),
                        movie.getPosterUrl(),
                        movie.getRating(),
                        movie.getMinute()
                ));
    }

    public List<MovieDTO> getPosters() {
        return movieRepository.getAllPosters()
                .stream()
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getName(),
                        movie.getDate(),
                        movie.getTagline(),
                        movie.getDescription(),
                        movie.getPosterUrl(),
                        movie.getRating(),
                        movie.getMinute()
                ))
                .collect(Collectors.toList());
    }

    public List<Movies> searchMoviesByName(String name) {
        PageRequest pageable = PageRequest.of(0, 100); // Offset 0, massimo 100 risultati
        return movieRepository.findByNameContainingIgnoreCase(name, pageable);
    }
}

