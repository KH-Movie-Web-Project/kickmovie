package kh.gangnam.kickmovie.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ApiUtil {

    @Value("${api.KEY}")
    private String apiKey;

    @Value("${api.searchMovie}")
    private String searchURL;
    @Value("${api.detailMovie}")
    private String detailURL;
    @Value("${api.actorListMovie}")
    private String actorListURL;
    @Getter
    @Value("${api.genre}")
    private String genreURL;
    @Value("${api.now}")
    @Getter
    private String nowURL;

    public String getSearchURL(String query){
        return searchURL + "?query=" + query + "&language=ko";
    }
    public String getSearchURL(String query, String year){
        return searchURL + "?query=" + query + "&year=" + year + "&language=ko";
    }
    public String getDetailURL(String movieID){
        return detailURL + movieID + "?language=ko";
    }
    public String getActorListURL(String movieID){
        return actorListURL + movieID + "/credits?language=ko";
    }


    public HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json");
        headers.add("Authorization", "Bearer " + apiKey);
        return headers;
    }
}
