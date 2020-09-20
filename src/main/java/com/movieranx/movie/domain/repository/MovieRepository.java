package com.movieranx.movie.domain.repository;

import com.movieranx.movie.domain.domain.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.Discover;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class MovieRepository {
    private final RestTemplate restTemplate;

    public MovieRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Movie getMovieById(String id) {
        String url = "https://api.themoviedb.org/3/movie/"+id+"?api_key=76f1f87c35d7c82f82a34ca61635e6a4";
        return this.restTemplate.getForObject(url, Movie.class);
    }

    public LinkedHashMap getMovieByName(String name) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=76f1f87c35d7c82f82a34ca61635e6a4&query=" + name;
        return this.restTemplate.getForObject(url, LinkedHashMap.class);
    }

    public ArrayList<MovieDb> getTopMoviesByGenre(String genre){
        Discover discover = new Discover();
        TmdbApi api = new TmdbApi("76f1f87c35d7c82f82a34ca61635e6a4");
        List<Genre> genres = api.getGenre().getGenreList("en");
        ArrayList<MovieDb> moviesWithGenre = new ArrayList<>();
        for(Genre _genre : genres){
            if(_genre.getName().equals(genre)){
                List<MovieDb> movies = api.getDiscover()
                        .getDiscover(discover.withGenres(_genre.getId()+"")
                        .sortBy("popularity.desc")
                        .includeAdult(false).releaseDateGte("2018"))
                        .getResults()   
                        .subList(0,5);
                for(MovieDb movie : movies){
                    MovieDb movieWithGenre = api.getMovies().getMovie(movie.getId(), "en-US");
                    moviesWithGenre.add(movieWithGenre);
                }
            }
        }
        return moviesWithGenre;
    }
}

