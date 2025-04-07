package kh.gangnam.kickmovie.components.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class DetailComponent{

    private final RestTemplate restTemplate;

    public ResponseEntity<?> fetchData(String url, HttpHeaders headers) {
        // TODO API 영화 상세 응답 데이터 DTO 제작하여 반환하기
        // URL과 Header는 Service에서 구현
        return null;
    }
}
