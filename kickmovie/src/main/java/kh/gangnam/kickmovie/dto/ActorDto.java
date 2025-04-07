package kh.gangnam.kickmovie.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActorDto {
    private Long id;
    private List<CastDto> cast;
    private List<CrewDto> crew;

}
