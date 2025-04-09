package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MovieGenre {

    @Id
    private long genreId;
    private String genreName;
}
