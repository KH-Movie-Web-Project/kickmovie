package kh.gangnam.kickmovie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kh.gangnam.kickmovie.dto.GenreResponse;
import kh.gangnam.kickmovie.dto.ResponseMovieSearchDTO;
import kh.gangnam.kickmovie.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("open-api/")
public class ApiController {

    private final ApiService apiService;

    @GetMapping("search")
    public List<ResponseMovieSearchDTO> getMovieSearch(@RequestParam(name = "query") String query) throws JsonProcessingException {
        return apiService.responseQuery(query);
    }


    // TODO Open API 장르 데이터 저장하기
    @GetMapping("movie/genre")
    public GenreResponse genreSave() {
        return apiService.genreSave();
    }
}
