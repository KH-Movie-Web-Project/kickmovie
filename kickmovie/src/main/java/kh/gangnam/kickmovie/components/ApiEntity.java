package kh.gangnam.kickmovie.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kh.gangnam.kickmovie.dto.*;
import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiEntity {

    private final ModelMapper modelMapper;

    // TODO MovieSearchDTO MovieSearch 엔티티로 변환 후 엔티티 반환
    // MovieSearchDTO → List<MovieSearch>
    public List<MovieSearch> convertToEntity(MovieSearchDTO dto) throws JsonProcessingException {
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
    public MovieDetail convertToEntity(MovieDetailDTO dto) {
        return modelMapper.map(dto, MovieDetail.class);
    }


    // TODO ActorDTO actor 엔티티로 변환 후 엔티티 반환
    // ActorDTO → List<Actor>
    public List<Actor> convertToEntity(ActorDto dto) {
        List<Actor> actorList = new ArrayList<>();
        for (CastDto castDto : dto.getCast()) {
            Actor actor = modelMapper.map(castDto, Actor.class);
            actorList.add(actor);
        }
        return actorList;
    }
}