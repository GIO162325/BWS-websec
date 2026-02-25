package com.example.websecurity.service;

import com.example.websecurity.api.dto.MovieResponse;
import com.example.websecurity.exception.WebSecMissingDataException;
import com.example.websecurity.persistence.Movie;
import com.example.websecurity.persistence.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PACKAGE;

@Service
@AllArgsConstructor(access = PACKAGE)
public class MovieService {
    private final MovieRepository movieRepository;


    public Movie getMovieById(Long id) {
       return movieRepository.findById(id).orElseThrow(() -> new WebSecMissingDataException("Movie with id " + id + " not found"));
    }
}
