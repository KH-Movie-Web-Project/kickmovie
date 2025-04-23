package kh.gangnam.kickmovie.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActorDTO {
    private Long id;
    private List<CastDTO> cast;
    private List<CrewDTO> crew;

}