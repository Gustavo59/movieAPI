package com.movieranx.movie.domain.service;

import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.repository.MovieRepository;
import info.movito.themoviedbapi.model.MovieDb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public Movie findMovieById(String id){
        Movie movie = null;

        try{
            movie = movieRepository.getMovieById(id);
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
            LinkedHashMap Movies = movieRepository.getMovieByName(name);
            ArrayList<Movie> ArrayMovies = (ArrayList<Movie>) Movies.get("results");
            movies = ArrayMovies;
        } catch (Exception e){
            log.error("Could not find movie!");
            log.error(e.getMessage());
            throw e;
        }

        return movies;
    }

    public ArrayList<MovieDb> getTopMoviesByGenre(String name) {
         ArrayList<MovieDb> movies;
        try {
            movies = movieRepository.getTopMoviesByGenre(name);
        } catch (Exception e) {
            log.error("Could not find genre!");
            log.error(e.getMessage());
            throw e;
        }

        return movies;

    }

    public ArrayList<MovieDb> getMoviesByIdList(List<String> moviesId){
        ArrayList<MovieDb> movies;

        try{
            movies = movieRepository.getMoviesByIdList(moviesId);
        }catch (Exception e){
            log.error("Could not retrive movie list");
            log.error(e.getMessage());
            throw e;
        }

        return movies;
    }
}
