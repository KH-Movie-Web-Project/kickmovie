package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "genre")
public class Genre {
    @Id
    private long id;
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<MovieSearch> movies = new ArrayList<>();
}
