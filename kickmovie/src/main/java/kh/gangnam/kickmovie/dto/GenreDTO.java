package kh.gangnam.kickmovie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GenreDTO {
    private long id;
    private String name;

    public GenreDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
