package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseMovieSearchDTO {
    private ResponseMovieSearch responseMovieSearch;
    private List<GenreDTO> genreDTOList;

    public ResponseMovieSearchDTO(ResponseMovieSearch responseMovieSearch, List<GenreDTO> genreDTOList) {
        this.responseMovieSearch = responseMovieSearch;
        this.genreDTOList = genreDTOList;
    }
}
