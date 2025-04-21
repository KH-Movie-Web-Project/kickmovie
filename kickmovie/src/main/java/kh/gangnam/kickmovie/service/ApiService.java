package kh.gangnam.kickmovie.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import kh.gangnam.kickmovie.components.ApiEntity;
import kh.gangnam.kickmovie.components.ApiResponse;
import kh.gangnam.kickmovie.components.api.ActorListComponent;
import kh.gangnam.kickmovie.dto.AllEntityDTO;
import kh.gangnam.kickmovie.dto.GenreDTO;
import kh.gangnam.kickmovie.dto.GenreResponse;
import kh.gangnam.kickmovie.entity.Genre;
import kh.gangnam.kickmovie.repository.GenreRepository;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiUtil apiUtil;
    private final ApiResponse apiResponse;
    private final ApiEntity apiEntity;
    private final GenreRepository genreRepository;


    // TODO 영화 검색어 입력시 검색된 영화 저장 트랜잭션
    @Transactional
    public void saveAllEntity(String query) throws JsonProcessingException {
        // TODO 검색어 리스트에 대한 엔티티 DTO set 가져오기
        List<AllEntityDTO> dtoList = apiEntity.responseApi(apiUtil.getSearchURL(query));

        // TODO 엔티티 매핑 후 저장 로직
        for (AllEntityDTO dto : dtoList) {
            // TODO MovieSearch 1 -- 1 MovieDetail

            // TODO MovieSearch N -- M Genre

            // TODO MovieDetail 1 -- N MovieActor

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
