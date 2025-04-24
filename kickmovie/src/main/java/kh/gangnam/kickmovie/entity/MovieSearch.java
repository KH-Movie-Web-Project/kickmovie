package kh.gangnam.kickmovie.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class MovieSearch {
    @Id
    private Long movieId;
    private boolean adult;
    private String backdrop_path;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String overview;
    private double popularity;
    @JsonProperty("poster_path")
    private String posterPath;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    @OneToOne(mappedBy = "movieSearch")
    private MovieDetail movieDetail;
}
