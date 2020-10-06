package com.movieranx.movie.domain.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Document(collection = "Movie")
public class Movie implements Serializable {


    @Id
    private String id;

    @NotNull
    private String original_title;

    private String budget;

    @NotNull
    private String release_date;

    @NotNull
    private String imdb_id;

    private String revenue;

    @NotNull
    private String overview;

    @NotNull
    private String poster_path;

    private ArrayList<?> genres;
}
