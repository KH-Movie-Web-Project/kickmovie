package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class GenreResponse {

    private List<GenreDTO> genres;
}
