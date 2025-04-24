package kh.gangnam.kickmovie.controller;

import kh.gangnam.kickmovie.dto.MovieSearchSimpleDTO;
import kh.gangnam.kickmovie.dto.ResponseGenreMovieDTO;
import kh.gangnam.kickmovie.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genre/movies")
    public ResponseEntity<ResponseGenreMovieDTO> getMoviesByGenre(@RequestParam(name = "genreId") Long genreId) {
        return ResponseEntity.ok(genreService.getMoviesByGenre(genreId));
    }
}