package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class MovieSearchDTO {
    private int page;
    private List<SearchResultDTO> results;
}
