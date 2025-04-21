package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreResponseDTO {
    private Long movie_id;
    private List<Integer> genre_ids;

    public GenreResponseDTO(Long movie_id, List<Integer> genre_ids) {
        this.movie_id = movie_id;
        this.genre_ids = genre_ids;
    }
}
