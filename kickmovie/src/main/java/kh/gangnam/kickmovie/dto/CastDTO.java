package kh.gangnam.kickmovie.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CastDTO {
    private boolean adult;
    private int gender;
    private Long id;
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
