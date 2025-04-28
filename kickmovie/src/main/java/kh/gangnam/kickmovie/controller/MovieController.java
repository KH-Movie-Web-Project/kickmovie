package kh.gangnam.kickmovie.controller;

import kh.gangnam.kickmovie.dto.ResponseMovieDetailDTO;
import kh.gangnam.kickmovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("movie")
    public ResponseEntity<ResponseMovieDetailDTO> getMovieDetailWithActors(@RequestParam(name = "movieId") Long movieId) {
        return ResponseEntity.ok(movieService.getMovieDetailWithActors(movieId));
    }

}
