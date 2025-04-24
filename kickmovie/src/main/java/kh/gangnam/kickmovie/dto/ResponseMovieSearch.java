package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMovieSearch {
    private Long movieId;
    private boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
