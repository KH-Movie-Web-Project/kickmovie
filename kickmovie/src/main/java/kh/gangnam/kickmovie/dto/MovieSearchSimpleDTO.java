package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieSearchSimpleDTO {
    private Long movieId;
    private String title;
    private String originalTitle;
    private String posterPath;
    private double popularity;
}
