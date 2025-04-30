package kh.gangnam.kickmovie.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDetailInfoDTO {


    private Long movieId;
    private boolean adult;
    private String homePage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;    private Double popularity;
    private String releaseDate;
    private List<GenreDTO> genres;

    private long budget;
    private String posterPath;
    private String backdropPath;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double voteAverage;
    private int voteCount;

}
