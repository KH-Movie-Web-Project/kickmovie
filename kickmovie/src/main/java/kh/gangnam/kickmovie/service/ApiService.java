package kh.gangnam.kickmovie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.EntityNotFoundException;
import kh.gangnam.kickmovie.components.ApiEntity;
import kh.gangnam.kickmovie.components.ApiResponse;
import kh.gangnam.kickmovie.dto.AllEntityDTO;
import kh.gangnam.kickmovie.dto.GenreDTO;
import kh.gangnam.kickmovie.dto.GenreResponse;
import kh.gangnam.kickmovie.dto.MovieActorInfoDTO;
import kh.gangnam.kickmovie.entity.*;
import kh.gangnam.kickmovie.repository.*;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    private final ApiUtil apiUtil;
    private final ApiResponse apiResponse;
    private final ApiEntity apiEntity;
    private final GenreRepository genreRepository;
    private final MovieActorRepository movieActorRepository;
    private final MovieSearchRepository movieSearchRepository;
    private final MovieDetailRepository movieDetailRepository;
    private final ActorRepository actorRepository;

    public void responseQuery(String query){
        // TODO 1. 데이터베이스에 해당 query 영화가 존재하는 지 확인. __{query}__ 로 진행

        // TODO 2. 해당 query 의 movieTitle 이 존재하고, 찾은 영화가 3개 이상이라면 그대로 출력
    }


    // TODO 영화 검색어 입력시 검색된 영화 저장 트랜잭션
    @Transactional
    public void saveAllEntity(String query) throws JsonProcessingException {
        // TODO 검색어 리스트에 대한 엔티티 DTO set 가져오기
        List<AllEntityDTO> dtoList = apiEntity.responseApi(apiUtil.getSearchURL(query));

        // TODO 엔티티 매핑 후 저장 로직
        for (AllEntityDTO dto : dtoList) {
            // TODO MovieSearch N -- M Genre
            MovieSearch movieSearch = dto.getMovieSearch();

            for (Integer genreId : dto.getGenres().getGenre_ids()) {
                // 1. 장르 리스트를 가지고 GenreRepository 에서 엔티티's 가져오기
                Genre genre = genreRepository.findById(Long.valueOf(genreId))
                        .orElseThrow(() -> new EntityNotFoundException("해당 GenreId가 없습니다."));
                // 2. movieSearch.getGenres().add(genre 엔티티)
                movieSearch.getGenres().add(genre);
            }
            // 3. movieRepository.save(movieSearch)
            movieSearchRepository.save(movieSearch);

            // TODO MovieSearch 1 -- 1 MovieDetail

            // 2. MovieDetail <-> MovieSearch 연관관계 매핑
            MovieDetail movieDetail = dto.getMovieDetail();
            movieDetail.setMovieSearch(movieSearch);
            movieDetail = movieDetailRepository.save(movieDetail);

            // TODO MovieDetail 1 -- N MovieActor
            // TODO Actor 1 -- N MovieActor
            // 1. Actor 필드 세팅
            for (MovieActorInfoDTO movieActorInfoDTO : dto.getMovieActorInfoDTOList()) {
                Actor actor = movieActorInfoDTO.getActor();

                // ⭐ 먼저 저장 (존재하지 않으면)
                Actor savedActor = actorRepository.findById(actor.getActorId())
                        .orElseGet(() -> actorRepository.save(actor)); // ✅ 여기서 저장 확정

                MovieActor movieActor = movieActorInfoDTO.getMovieActor();
                movieActor.setMovieDetail(movieDetail);     // MovieDetail은 이미 저장됨
                movieActor.setActor(savedActor);            // 참조 가능한 Actor

                movieActorRepository.save(movieActor);      // ✅ 안전하게 저장 가능
            }

        }
    }
    // TODO 영화 장르 데이터 응답받아 저장하는 로직
    public GenreResponse genreSave() {
        String url = apiUtil.getGenreURL();
        GenreResponse genreResponse = apiResponse.genreListData(url, apiUtil.createHeaders());
        for (GenreDTO genreDTO : genreResponse.getGenres()) {
            Genre genre = new Genre();
            genre.setId(genreDTO.getId());
            genre.setName(genreDTO.getName());
            genreRepository.save(genre);
        }
        return genreResponse;
    }
}
