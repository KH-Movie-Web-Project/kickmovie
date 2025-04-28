package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseGenreMovieDTO {
    private Long genreId;
    private String genreName;
    private List<MovieSearchSimpleDTO> movieSearchDTOList;
}
