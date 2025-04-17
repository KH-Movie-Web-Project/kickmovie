package kh.gangnam.kickmovie.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kh.gangnam.kickmovie.dto.*;
import kh.gangnam.kickmovie.entity.Actor;
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
    public void convertToEntity(MovieSearchDTO dto) throws JsonProcessingException {
        List<MovieSearch> movieSearchList = new ArrayList<>();
        for (SearchResultDTO resultDTO : dto.getResults()) {
            MovieSearch entity = modelMapper.map(resultDTO, MovieSearch.class);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            String prettyDTO = objectMapper.writeValueAsString(entity);
            log.info("Entity: \n{}", prettyDTO);
            movieSearchList.add(entity);
        }
    }
    // TODO MovieDetailDTO MovieDetail 엔티티로 변환 후 엔티티 반환
    public void convertToEntity(MovieDetailDTO dto){

    }
    // TODO ActorDTO actor 엔티티로 변환 후 엔티티 반환
    public void convertToEntity(ActorDto dto){
        for (CastDto castDto : dto.getCast()) {
            Actor actor = new Actor();
            actor.setActorId(castDto.getId());
            actor.setAdult(castDto.isAdult());
            actor.setGender(castDto.getGender());
            actor.setKnownForDepartment(castDto.getKnownForDepartment());
            actor.setName(castDto.getName());
            actor.setOriginalName(castDto.getOriginalName());
            actor.setPopularity(castDto.getPopularity());
            actor.setProfilePath(castDto.getProfilePath());
            actor.setCastId(castDto.getCastId());
            actor.setCharacter(castDto.getCharacter());
            actor.setCreditId(castDto.getCreditId());
            actor.setOrder(castDto.getOrder());
        }
    }
}
