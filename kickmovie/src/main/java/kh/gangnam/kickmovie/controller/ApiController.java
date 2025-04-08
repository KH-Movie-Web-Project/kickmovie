package kh.gangnam.kickmovie.controller;

import kh.gangnam.kickmovie.service.ApiService;
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

    // TODO Open API 검색어를 통한 영화 리스트 받아오기 (query)
    @GetMapping("movie/search/{query}")
    public ResponseEntity<?> searchMovie(@PathVariable(value = "query") String query){
        return apiService.searchMovie(query);
    }
    // TODO Open API 검색어, 년도를 통한 영화 리스트 받아오기 (query, year)
    @GetMapping("movie/search/{query}/{year}")
    public ResponseEntity<?> searchMovie(@PathVariable(value = "query") String query,
                                         @PathVariable(value = "year") String year){
        return apiService.searchMovie(query, year);
    }

    // TODO Open API 영화 상세 데이터 받아오기 (movie_id)
    @GetMapping("movie/detail/{movieID}")
    public ResponseEntity<?> detailMovie(@PathVariable(value = "movieID") String movieID) {
        return apiService.detailMovie(movieID);
    }

    // TODO Open API 영화 배우 데이터 받아오기 (actor_id)
    @GetMapping("/movie/actor/{movieID}")
    public ResponseEntity<?> actorMovie(@PathVariable(value = "movieID") String movieID) {
        return apiService.actorMovie(movieID);
    }

}
