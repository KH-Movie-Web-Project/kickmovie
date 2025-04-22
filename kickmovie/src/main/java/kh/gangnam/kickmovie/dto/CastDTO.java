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
    @JsonProperty("known_for_department")
    private String knownForDepartment;
    private String name;
    @JsonProperty("original_name")
    private String originalName;
    private Double popularity;
    @JsonProperty("profile_path")
    private String profilePath;
    @JsonProperty("cast_id")
    private int castId;
    private String character;
    @JsonProperty("credit_id")
    private String creditId;
    @JsonProperty("order")
    private int actorOrder;
}
