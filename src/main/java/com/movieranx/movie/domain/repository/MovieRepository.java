package com.movieranx.movie.domain.repository;

import com.movieranx.movie.domain.domain.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {


}
