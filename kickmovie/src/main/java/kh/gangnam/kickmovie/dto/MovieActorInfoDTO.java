package kh.gangnam.kickmovie.dto;

import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieActor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieActorInfoDTO {
    private Actor actor;
    private MovieActor movieActor;

    public MovieActorInfoDTO(Actor actor, MovieActor movieActor) {
        this.actor = actor;
        this.movieActor = movieActor;
    }
}
