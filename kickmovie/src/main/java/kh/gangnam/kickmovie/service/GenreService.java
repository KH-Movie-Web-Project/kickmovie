package kh.gangnam.kickmovie.service;

import jakarta.persistence.EntityNotFoundException;
import kh.gangnam.kickmovie.dto.MovieSearchSimpleDTO;
import kh.gangnam.kickmovie.dto.ResponseGenreMovieDTO;
import kh.gangnam.kickmovie.entity.Genre;
import kh.gangnam.kickmovie.entity.MovieSearch;
import kh.gangnam.kickmovie.mapper.MovieMapper;
import kh.gangnam.kickmovie.repository.GenreRepository;
import kh.gangnam.kickmovie.repository.MovieSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final MovieSearchRepository movieSearchRepository;
    private final MovieMapper movieMapper;
    private final GenreRepository genreRepository;


    public ResponseGenreMovieDTO getMoviesByGenre(Long genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new EntityNotFoundException("해당 장르가 없습니다"));

        List<MovieSearch> movies = movieSearchRepository.findByGenreId(genreId);
        List<MovieSearchSimpleDTO> dtoList = movies.stream()
                .map(movieMapper::toSimpleDTO)
                .collect(Collectors.toList());

        ResponseGenreMovieDTO response = new ResponseGenreMovieDTO();
        response.setGenreId(genre.getId());
        response.setGenreName(genre.getName());
        response.setMovieSearchDTOList(dtoList);
        return response;
    }
}
