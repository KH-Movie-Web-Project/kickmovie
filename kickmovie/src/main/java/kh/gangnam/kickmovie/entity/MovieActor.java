package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class MovieActor {

    @Id
    private Long id;

    // 연관관계 Actor N:1
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    // 연관관계 MovieDetail N:1
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieDetail movieDetail;

    //private String role;
}
