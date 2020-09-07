package com.movieranx.movie.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Movie")
public class MovieRequest {

    @Id
    private String id;

    @NotNull
    private String title;

    @NotNull
    private String budget;

    @NotNull
    private String releaseDate;

    @NotNull
    private String revenue;

    @NotNull
    private String genres;
}
