package com.movieranx.movie.domain.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

    public ArrayList<Movie> findMovieByName(String name) {
        ArrayList<Movie> movies = null;

        try{
            LinkedHashMap response = repository.getMovieByName(name);
            if(response.containsKey("results")) {
                movies = (ArrayList<Movie>) response.get("results");
            }
            return movies;
        } catch (Exception e){
            log.error("Could not find movie!");
            log.error(e.getMessage());
            throw e;
        }
    }

    /*public ArrayList<Movie> findTopMoviesByGenre(String genre){
        ArrayList<Movie> movies = null;

        try{
            movies = repository.findFirst10ByGenresRegexOrderByRevenueDesc(genre);
        } catch(Exception e){
            log.error("Cold not find movie by genre");
            log.error(e.getMessage());
            throw e;
        }

        return movies;
    }*/
}
