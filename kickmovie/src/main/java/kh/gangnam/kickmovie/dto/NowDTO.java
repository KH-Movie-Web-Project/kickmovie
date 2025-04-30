package kh.gangnam.kickmovie.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NowDTO {

    private Dates dates;
    private long page;
    private List<SearchResultDTO> results;
    private String total_pages;
    private String total_results;
}
