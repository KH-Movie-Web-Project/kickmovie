package kh.gangnam.kickmovie.components.api;

import kh.gangnam.kickmovie.dto.MovieSearchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class SearchListComponent{

    private final RestTemplate restTemplate;

    public MovieSearchDTO fetchData(String url, HttpHeaders headers) {
        // TODO API 검색 영화 리스트 응답 데이터 DTO로 반환하기
        // URL과 Header는 Service에서 구현
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<MovieSearchDTO> search = restTemplate.exchange(url, HttpMethod.GET, entity, MovieSearchDTO.class);

        return search.getBody();
    }
}
