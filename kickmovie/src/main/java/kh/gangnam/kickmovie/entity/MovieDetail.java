package kh.gangnam.kickmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
    @Lob
    @Column(columnDefinition = "TEXT")
    private String overview;    private Double popularity;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double voteAverage;
    private int voteCount;

    @OneToOne
    @JoinColumn(name = "id")
    private MovieSearch movieSearch;

    @OneToMany(mappedBy = "movieDetail", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieActor> movieActors = new ArrayList<>();
}
