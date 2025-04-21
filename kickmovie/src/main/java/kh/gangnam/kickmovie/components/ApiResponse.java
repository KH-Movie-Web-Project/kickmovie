package kh.gangnam.kickmovie.components;

import kh.gangnam.kickmovie.components.api.ActorListComponent;
import kh.gangnam.kickmovie.components.api.DetailComponent;
import kh.gangnam.kickmovie.components.api.GenreListComponent;
import kh.gangnam.kickmovie.components.api.SearchListComponent;
import kh.gangnam.kickmovie.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiResponse {

    private final SearchListComponent searchListComponent;
    private final DetailComponent detailComponent;
    private final ActorListComponent actorListComponent;
    private final GenreListComponent genreListComponent;


    public MovieSearchDTO searchListData(String url, HttpHeaders headers) {
        return searchListComponent.fetchData(url, headers);
    }
    public MovieDetailDTO detailData(String url, HttpHeaders headers) {
        return detailComponent.fetchData(url, headers);
    }
    public ActorDTO actorListData(String url, HttpHeaders headers) {
        return actorListComponent.fetchData(url, headers);
    }
    public GenreResponse genreListData(String url, HttpHeaders headers) {
        return genreListComponent.fetchData(url, headers);
    }

}
