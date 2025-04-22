package kh.gangnam.kickmovie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.persistence.EntityNotFoundException;
import kh.gangnam.kickmovie.components.ApiEntity;
import kh.gangnam.kickmovie.components.ApiResponse;
import kh.gangnam.kickmovie.dto.AllEntityDTO;
import kh.gangnam.kickmovie.dto.GenreDTO;
import kh.gangnam.kickmovie.dto.GenreResponse;
import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.Genre;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import kh.gangnam.kickmovie.repository.ActorRepository;
import kh.gangnam.kickmovie.repository.GenreRepository;
import kh.gangnam.kickmovie.repository.MovieDetailRepository;
import kh.gangnam.kickmovie.repository.MovieSearchRepository;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiService {

    private final ApiUtil apiUtil;
    private final ApiResponse apiResponse;
    private final ApiEntity apiEntity;
    private final GenreRepository genreRepository;
    private final MovieSearchRepository movieSearchRepository;
    private final MovieDetailRepository movieDetailRepository;
    private final ActorRepository actorRepository;


    // TODO 영화 검색어 입력시 검색된 영화 저장 트랜잭션
    @Transactional
    public void saveAllEntity(String query) throws JsonProcessingException {
        // TODO 검색어 리스트에 대한 엔티티 DTO set 가져오기
        List<AllEntityDTO> dtoList = apiEntity.responseApi(apiUtil.getSearchURL(query));

        // TODO 엔티티 매핑 후 저장 로직
        for (AllEntityDTO dto : dtoList) {
            /* 로그 Json 방식으로 찍는 법
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String prettyDTO = objectMapper.writeValueAsString(dto);
            log.info("Entity: \n{}", prettyDTO);
             */

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

            // 3. MovieDetail 저장
            movieDetail = movieDetailRepository.save(movieDetail);

            // TODO MovieDetail 1 -- N MovieActor
            // 1. Actor 필드 세팅

            // TODO Actor 1 -- N MovieActor
        }
    }

//    // TODO 영화 검색어로 가져오기 Service 로직
//    public ResponseEntity<?> searchMovie(String query) {
//        String url = apiUtil.getSearchURL(query);
//        return apiResponse.searchListData(url, apiUtil.createHeaders());
//    }
//
//    // TODO 영화 검색어, 년도로 가져오기 Service 로직
//    public ResponseEntity<?> searchMovie(String query, String year) {
//        String url = apiUtil.getSearchURL(query, year);
//        return apiResponse.searchListData(url, apiUtil.createHeaders());
//    }
//
//    // TODO 영화 상세 데이터 가져오기 Service 로직
//    public ResponseEntity<?> detailMovie(String movieId) {
//        String url = apiUtil.getDetailURL(movieId);
//        return apiResponse.detailData(url, apiUtil.createHeaders());
//    }
//
//    // TODO 영화 배우 데이터 가져오기 Service 로직
//    public ResponseEntity<?> actorMovie(String movieID) {
//        String url = apiUtil.getActorListURL(movieID);
//        return apiResponse.actorListData(url, apiUtil.createHeaders());
//    }

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
