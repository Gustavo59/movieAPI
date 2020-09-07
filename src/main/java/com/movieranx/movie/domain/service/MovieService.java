package com.movieranx.movie.domain.service;

import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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


    public ArrayList<Movie> findTopMoviesByGenre(String genre){
        ArrayList<Movie> movies = null;

        try{
            movies = repository.findFirst10ByGenresRegexOrderByRevenueDesc(genre);
        } catch(Exception e){
            log.error("Cold not find movie by genre");
            log.error(e.getMessage());
            throw e;
        }

        return movies;
    }
}
