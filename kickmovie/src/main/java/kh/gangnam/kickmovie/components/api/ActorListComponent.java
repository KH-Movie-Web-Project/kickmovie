package kh.gangnam.kickmovie.components.api;

import kh.gangnam.kickmovie.dto.ActorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
@RequiredArgsConstructor
public class ActorListComponent{

    private final RestTemplate restTemplate;

    public ResponseEntity<ActorDto> fetchData(String url, HttpHeaders headers) {
        // TODO API 호출하여 배우 리스트 응답 데이터 DTO 반환하기
        // URL과 Header는 Service에서 구현
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<ActorDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, ActorDto.class);
        return ResponseEntity.ok(response.getBody());
    }
}
