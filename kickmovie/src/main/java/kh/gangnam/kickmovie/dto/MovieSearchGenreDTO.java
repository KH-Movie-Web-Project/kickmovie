package kh.gangnam.kickmovie.dto;

import kh.gangnam.kickmovie.entity.MovieSearch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class MovieSearchGenreDTO {

    private MovieSearch movieSearch;
    private GenreResponseDTO genreResponseDTO;

    public MovieSearchGenreDTO(MovieSearch movieSearch, GenreResponseDTO genreResponseDTO) {
        this.movieSearch = movieSearch;
        this.genreResponseDTO = genreResponseDTO;
    }
}
