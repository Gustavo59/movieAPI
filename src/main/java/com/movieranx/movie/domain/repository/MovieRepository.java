package com.movieranx.movie.domain.repository;

import com.movieranx.movie.domain.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    //@Query("{genres : {$regex : ?0}}")
    ArrayList<Movie> findFirst10ByGenresRegexOrderByRevenueDesc(String genre);

}

