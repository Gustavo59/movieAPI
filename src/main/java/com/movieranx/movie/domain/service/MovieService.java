package com.movieranx.movie.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieRepository repository;

    public Movie findMovieById(String id){
        Movie movie = null;

        try{
            movie = repository.getMovieById(id);
        } catch (Exception e){
            log.error("Could not find movie!");
            log.error(e.getMessage());
            throw e;
        }

        return movie;
    }

    public ArrayList<Movie> findMovieByName(String name){
        ArrayList<Movie> movies = null;

        try{
            LinkedHashMap Movies = repository.getMovieByName(name);
            ArrayList<Movie> ArrayMovies = (ArrayList<Movie>) teste.get("results");
            movies = ArrayMovies;
        } catch (Exception e){
            log.error("Could not find movie!");
            log.error(e.getMessage());
            throw e;
        }

        return movies;
    }
}
