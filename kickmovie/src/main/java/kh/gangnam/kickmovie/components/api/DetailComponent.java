package kh.gangnam.kickmovie.components.api;

import kh.gangnam.kickmovie.dto.MovieDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
@RequiredArgsConstructor
public class DetailComponent{

    private final RestTemplate restTemplate;

    public MovieDetailDTO fetchData(String url, HttpHeaders headers) {

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MovieDetailDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                MovieDetailDTO.class
        );
        return response.getBody();
    }
}
