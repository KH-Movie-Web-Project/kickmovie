package kh.gangnam.kickmovie.mapper;

import kh.gangnam.kickmovie.dto.*;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import kh.gangnam.kickmovie.entity.MovieActor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public MovieSearchSimpleDTO toSimpleDTO(MovieSearch movie) {
        return modelMapper.map(movie, MovieSearchSimpleDTO.class);
    }

    public MovieDetailInfoDTO toDetailDTO(MovieDetail detail) {
        return modelMapper.map(detail, MovieDetailInfoDTO.class);
    }

    public MovieActorDTO toActorDTO(MovieActor actor) {
        return modelMapper.map(actor, MovieActorDTO.class);
    }

    public List<MovieActorDTO> toActorDTOList(List<MovieActor> actors) {
        return actors.stream().map(this::toActorDTO).collect(Collectors.toList());
    }

    public ResponseMovieDetailDTO toResponseMovieDetailDTO(MovieDetail detail) {
        ResponseMovieDetailDTO response = new ResponseMovieDetailDTO();
        response.setMovieDetailInfoDTO(toDetailDTO(detail));
        response.setMovieActorDTOList(toActorDTOList(detail.getMovieActors()));
        return response;
    }
}
