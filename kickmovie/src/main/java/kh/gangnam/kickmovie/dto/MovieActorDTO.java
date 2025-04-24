package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieActorDTO {

    private String name;
    private String profilePath;
    private int castId;
    private String character;
    private String creditId;
    private int actorOrder;

    // MovieDetail 내용
    private String movieTitle;



}
