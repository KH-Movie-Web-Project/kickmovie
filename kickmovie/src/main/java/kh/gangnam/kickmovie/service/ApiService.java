package kh.gangnam.kickmovie.service;

import kh.gangnam.kickmovie.components.ApiClient;
import kh.gangnam.kickmovie.components.api.ActorListComponent;
import kh.gangnam.kickmovie.dto.ActorDto;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiUtil apiUtil;
    private final ApiClient apiClient;
    private final ActorListComponent actorListComponent;

    // TODO 영화 검색어로 가져오기 Service 로직
    public ResponseEntity<?> searchMovie(String query) {
        String url = apiUtil.getSearchURL(query);
        return apiClient.searchListData(url, apiUtil.createHeaders());
    }

    // TODO 영화 검색어, 년도로 가져오기 Service 로직
    public ResponseEntity<?> searchMovie(String query, String year) {
        String url = apiUtil.getSearchURL(query, year);
        return apiClient.searchListData(url, apiUtil.createHeaders());
    }

    // TODO 영화 상세 데이터 가져오기 Service 로직
    public ResponseEntity<?> detailMovie(String movieId) {
        String url = apiUtil.getDetailURL(movieId);
        return apiClient.detailData(url, apiUtil.createHeaders());
    }

    // TODO 영화 배우 데이터 가져오기 Service 로직
    public ResponseEntity<ActorDto> actorMovie(String movieID) {
        String url = apiUtil.getActorListURL(movieID);
        HttpHeaders headers = apiUtil.createHeaders();
        ResponseEntity<ActorDto> response = actorListComponent.fetchData(url,headers);
        return response;
    }
}
