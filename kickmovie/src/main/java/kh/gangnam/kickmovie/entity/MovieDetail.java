package kh.gangnam.kickmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieDetail {

    @Id
    private Long movieId;

    private boolean adult;
    private String homePage;
    private String imdbId;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double voteAverage;
    private int voteCount;

    // 관계 매핑은 나중에 필요 시 추가
    @OneToOne
    @JoinColumn(name = "id") // MovieDetail.id와 MovieSearch.movie_id가 동일
    private MovieSearch movieSearch;
}
