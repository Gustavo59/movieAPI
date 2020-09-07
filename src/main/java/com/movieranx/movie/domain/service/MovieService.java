package com.movieranx.movie.domain.service;

import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieRepository repository;

    public Optional<Movie> findMovieById(String id){
        Optional<Movie> movie = null;

        try{
            movie = repository.findById(id);
        } catch (Exception e){
            log.error("Could not find movie!");
            log.error(e.getMessage());
            throw e;
        }

        return movie;
    }
}
