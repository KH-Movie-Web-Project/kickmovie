package kh.gangnam.kickmovie.service;

import jakarta.persistence.EntityNotFoundException;
import kh.gangnam.kickmovie.dto.NowDTO;
import kh.gangnam.kickmovie.dto.ResponseMovieDetailDTO;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.mapper.MovieMapper;
import kh.gangnam.kickmovie.repository.MovieDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieDetailRepository movieDetailRepository;
    private final MovieMapper movieMapper;

    public ResponseMovieDetailDTO getMovieDetailWithActors(Long movieId) {
        MovieDetail entity = movieDetailRepository.findById(movieId)
                .orElseThrow(() -> new EntityNotFoundException("해당 영화가 없습니다"));

        return movieMapper.toResponseMovieDetailDTO(entity);
    }

}
