package com.andrianigiordano.springboot.movies;

import com.andrianigiordano.springboot.countries.CountriesRepository;
import com.andrianigiordano.springboot.crew.CrewRepository;
import com.andrianigiordano.springboot.genres.GenresRepository;
import com.andrianigiordano.springboot.languages.LanguagesRepository;
import com.andrianigiordano.springboot.studios.StudiosRepository;
import com.andrianigiordano.springboot.themes.ThemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MoviesService {
    @Autowired
    private MoviesRepository movieRepository;
    @Autowired
    private ThemesRepository themesRepository;
    @Autowired
    private CrewRepository crewRepository;
    @Autowired
    private GenresRepository genresRepository;
    @Autowired
    private CountriesRepository countriesRepository;
    @Autowired
    private LanguagesRepository languagesRepository;
    @Autowired
    private StudiosRepository studiosRepository;


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

    public String getThemesByMovieId(Long movieId) {
        return themesRepository.findByMovieId(movieId);
    }

    public String getCrewByMovieId(Long movieId) {
        return crewRepository.findByMovieId(movieId);
    }

    public String getGenresByMovieId(Long movieId) {
        return genresRepository.findByMovieId(movieId);

    }

    public String getCountriesByMovieId(Long movieId) {
        return countriesRepository.findByMovieId(movieId);

    }

    public String getLanguagesByMovieId(Long movieId) {
        return languagesRepository.findByMovieId(movieId);

    }

    public String getStudiosByMovieId(Long movieId) {
        return studiosRepository.findByMovieId(movieId);

    }
}

