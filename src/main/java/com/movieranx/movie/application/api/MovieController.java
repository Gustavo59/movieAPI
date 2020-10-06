package com.movieranx.movie.application.api;

import com.movieranx.movie.domain.domain.Movie;
import com.movieranx.movie.domain.service.MovieService;
import info.movito.themoviedbapi.model.MovieDb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/movie")
@Slf4j
public class MovieController {

    @Autowired
    private MovieService service;

    @CrossOrigin("*")
    @GetMapping("/findbyid/{id}")
    public ResponseEntity<?> findMovieById(@PathVariable String id){
        log.info("Finding movie by id.... with id:" + id);

        Movie movie;

        try{
            movie = service.findMovieById(id);
        } catch (Exception e){
            log.error("Error while finding movie with ID " + id, e.getCause());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(movie == null){
            return new ResponseEntity<>("Could not find movie", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/findbyname/{name}")
    public ResponseEntity<?> findMovieByName(@PathVariable String name){
        log.info("Finding movie by name....");

        ArrayList<Movie> movies;

        try{
            movies = service.findMovieByName(name);
        } catch (Exception e){
            log.error("Error while finding movie with Name " + name, e.getCause());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(movies == null){
            return new ResponseEntity<>("Could not found movie", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @GetMapping("/getTopMoviesByGenre/{name}")
    public ArrayList<MovieDb> getTopMoviesByGenre(@PathVariable String name){
        log.info("Finding genre by name....");
        ArrayList<MovieDb> movies = service.getTopMoviesByGenre(name);
        return movies;
    }

    @CrossOrigin("*")
    @GetMapping("/getmoviesbyid")
    public ArrayList<MovieDb> getAllMoviesById(@RequestParam List<String> movies){
        log.info("Getting movies");

        ArrayList<MovieDb> response = service.getMoviesByIdList(movies);

        return response;
    }

    @CrossOrigin("*")
    @GetMapping("/getmoviesbyimdbid")
    public ArrayList<MovieDb> getAllMoviesByImdbId(@RequestParam List<String> movies){
        log.info("Getting movies by imdbid");

        ArrayList<MovieDb> response = service.getMoviesByImdbIdList(movies);

        return response;
    }

    @CrossOrigin("*")
    @GetMapping("/findMoviesByTerm/{term}")
    public ArrayList<MovieDb> findMoviesByTerm(@PathVariable String term){
        log.info("getting movie by term with term: "+term);

        ArrayList<MovieDb> response = service.getMoviesByTerm(term);

        return response;
    }

}
