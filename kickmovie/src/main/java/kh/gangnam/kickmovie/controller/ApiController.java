package kh.gangnam.kickmovie.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kh.gangnam.kickmovie.dto.GenreDTO;
import kh.gangnam.kickmovie.dto.GenreResponse;
import kh.gangnam.kickmovie.service.ApiService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("open-api/")
public class ApiController {

    private final ApiService apiService;

    @GetMapping("test")
    public void test() throws JsonProcessingException {
        apiService.saveAllEntity("기생충");
    }


    // TODO Open API 장르 데이터 저장하기
    @GetMapping("movie/genre")
    public GenreResponse genreSave() {
        return apiService.genreSave();
    }
}
