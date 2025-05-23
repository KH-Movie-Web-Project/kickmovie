package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseMovieDetailDTO {

    private MovieDetailInfoDTO movieDetailInfoDTO;
    private List<MovieActorDTO> movieActorDTOList;
}
