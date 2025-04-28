package kh.gangnam.kickmovie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BelongsToCollectionDTO {
    private int id;
    private String name;
    @JsonProperty("poster_path")
    private String posterPath;
    @JsonProperty("backdrop_path")
    private String backdropPath;
}
