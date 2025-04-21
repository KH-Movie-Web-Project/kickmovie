package kh.gangnam.kickmovie.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kh.gangnam.kickmovie.dto.*;
import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiEntity {

    private final ModelMapper modelMapper;
    private final ApiResponse apiResponse;
    private final ApiUtil apiUtil;

    // TODO Service 에서 검색어 한 번 들어왔을 때 저장해야 하는 데이터셋 지정
    public List<AllEntityDTO> responseApi(String url) throws JsonProcessingException {
        HttpHeaders headers = apiUtil.createHeaders();
        List<MovieSearch> movieSearchList = convertToEntity(
                apiResponse.searchListData(url, headers)
        );
        List<AllEntityDTO> allEntityDTOList = new ArrayList<>();
        for (MovieSearch movieSearch : movieSearchList) {
            allEntityDTOList.add(setMovieEntity(movieSearch, headers));
        }
        return allEntityDTOList;
    }

    // TODO AllEntityDTO movieSearch 한 개당 저장할 데이터셋
    private AllEntityDTO setMovieEntity(MovieSearch movieSearch, HttpHeaders headers) throws JsonProcessingException {

        String movie_id = String.valueOf(movieSearch.getId());
        MovieDetail movieDetail = convertToEntity(
                apiResponse.detailData(
                        apiUtil.getDetailURL(movie_id), headers)
        );
        List<Actor> actorList = convertToEntity(
                apiResponse.actorListData(
                        apiUtil.getActorListURL(movie_id), headers)
        );
        return new AllEntityDTO(actorList, movieDetail, movieSearch);
    }

    // TODO MovieSearchDTO MovieSearch 엔티티로 변환 후 엔티티 반환
    // MovieSearchDTO → List<MovieSearch>
    private List<MovieSearch> convertToEntity(MovieSearchDTO dto) throws JsonProcessingException {
        List<MovieSearch> movieSearchList = new ArrayList<>();
        for (SearchResultDTO resultDTO : dto.getResults()) {
            MovieSearch entity = modelMapper.map(resultDTO, MovieSearch.class);
            // log 부분
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String prettyDTO = objectMapper.writeValueAsString(entity);
            log.info("Entity: \n{}", prettyDTO);
            // 여기까지 로그
            movieSearchList.add(entity);
        }
        return movieSearchList;

    }
    // TODO MovieDetailDTO MovieDetail 엔티티로 변환 후 엔티티 반환
    // MovieDetailDTO → MovieDetail
    private MovieDetail convertToEntity(MovieDetailDTO dto) throws JsonProcessingException {
        MovieDetail entity = modelMapper.map(dto, MovieDetail.class);
        // log 부분
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String prettyDTO = objectMapper.writeValueAsString(entity);
        log.info("MovieDetail Entity:\n{}", prettyDTO);
        // 여기까지 로그
        return entity;
    }

    // TODO ActorDTO actor 엔티티로 변환 후 엔티티 반환
    // ActorDTO → List<Actor>
    private List<Actor> convertToEntity(ActorDTO dto) throws JsonProcessingException {
        List<Actor> actorList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // log 부분
        for (CastDTO castDto : dto.getCast()) {
            Actor actor = modelMapper.map(castDto, Actor.class);
            String prettyActor = objectMapper.writeValueAsString(actor);
            log.info("Actor Entity:\n{}", prettyActor);
            actorList.add(actor);
        }
        // 여기까지 로그
        return actorList;
    }
}