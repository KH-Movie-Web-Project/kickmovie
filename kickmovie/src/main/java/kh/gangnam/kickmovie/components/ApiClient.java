package kh.gangnam.kickmovie.components;

import kh.gangnam.kickmovie.components.api.ActorListComponent;
import kh.gangnam.kickmovie.components.api.DetailComponent;
import kh.gangnam.kickmovie.components.api.SearchListComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiClient {

    private final SearchListComponent searchListComponent;
    private final DetailComponent detailComponent;
    private final ActorListComponent actorListComponent;

    public ResponseEntity<?> searchListData(String url, HttpHeaders headers) {
        return searchListComponent.fetchData(url, headers);
    }
    public ResponseEntity<?> detailData(String url, HttpHeaders headers) {
        return detailComponent.fetchData(url, headers);
    }
    public ResponseEntity<?> actorListData(String url, HttpHeaders headers) {
        return actorListComponent.fetchData(url, headers);
    }

}
