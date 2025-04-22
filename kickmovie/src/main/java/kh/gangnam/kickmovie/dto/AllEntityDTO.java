package kh.gangnam.kickmovie.dto;

import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieActor;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import lombok.Getter;

import java.util.List;

@Getter
public class AllEntityDTO {

    private MovieSearch movieSearch;
    private GenreResponseDTO genres;
    private MovieDetail movieDetail;
    private List<MovieActorInfoDTO> movieActorInfoDTOList;

    public AllEntityDTO(MovieSearch movieSearch
            , GenreResponseDTO genres
            , MovieDetail movieDetail
            , List<MovieActorInfoDTO> movieActorInfoDTOList) {
        this.movieSearch = movieSearch;
        this.genres = genres;
        this.movieDetail = movieDetail;
        this.movieActorInfoDTOList = movieActorInfoDTOList;
    }
}
