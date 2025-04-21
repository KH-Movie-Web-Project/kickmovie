package kh.gangnam.kickmovie.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
public class MovieSearch {
    @Id
    private int id;
    private boolean adult;
    private String backdrop_path;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
