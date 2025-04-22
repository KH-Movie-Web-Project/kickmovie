package kh.gangnam.kickmovie.entity;

import jakarta.persistence.*;
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

    // 영화와 배우 합친 요소들
    private String name;
    private String profilePath;
    private int castId;
    @Column(name = "character_name")
    private String character;
    private String creditId;
    private int actorOrder;
    private String movieTitle;

}
