package kh.gangnam.kickmovie.controller;

import kh.gangnam.kickmovie.dto.ResponseMovieDetailDTO;
import kh.gangnam.kickmovie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{movieId}")
    public ResponseEntity<ResponseMovieDetailDTO> getMovieDetailWithActors(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovieDetailWithActors(movieId));
    }

}
