package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;

public class Movie {

    @Id
    private int id;
    private boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
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
