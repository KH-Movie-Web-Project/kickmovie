package kh.gangnam.kickmovie.dto;

import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import lombok.Getter;

import java.util.List;

@Getter
public class AllEntityDTO {

    private List<Actor> actorList;
    private MovieDetail movieDetail;
    private MovieSearch movieSearch;

    public AllEntityDTO(List<Actor> actorList, MovieDetail movieDetail, MovieSearch movieSearch) {
        this.actorList = actorList;
        this.movieDetail = movieDetail;
        this.movieSearch = movieSearch;
    }
}
