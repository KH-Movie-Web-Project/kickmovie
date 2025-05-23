package kh.gangnam.kickmovie.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CrewDTO {
    private boolean adult;
    private int gender;
    private int id;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private Number popularity;
    private String profilePath;
    private String creditId;
    private String department;
    private String job;

}
