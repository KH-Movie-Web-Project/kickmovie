package kh.gangnam.kickmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieActor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    // CastDTO 내용
    private String name;
    private String profilePath;
    private int castId;
    @Column(name = "character_name")
    private String character;
    private String creditId;
    private int actorOrder;

    // MovieDetail 내용
    private String movieTitle;

}
