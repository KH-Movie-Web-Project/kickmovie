package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Genre {
    @Id
    private long id;
    private String name;
}
