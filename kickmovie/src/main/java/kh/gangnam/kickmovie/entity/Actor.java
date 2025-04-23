package kh.gangnam.kickmovie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Actor {
    @Id
    private Long actorId;
    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private Double popularity;
    private String profilePath;

    @OneToMany(mappedBy = "actor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieActor> movieActors = new ArrayList<>();
}
