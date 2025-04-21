package kh.gangnam.kickmovie.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CastDTO {
    @JsonProperty("id")
    private Long actorId;
    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private Double popularity;
    private String profilePath;
    private int castId;
    private String character;
    private String creditId;
    private int order;
}
