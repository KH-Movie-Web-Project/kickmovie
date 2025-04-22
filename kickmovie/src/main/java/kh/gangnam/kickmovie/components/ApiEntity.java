package kh.gangnam.kickmovie.components;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kh.gangnam.kickmovie.dto.*;
import kh.gangnam.kickmovie.entity.Actor;
import kh.gangnam.kickmovie.entity.MovieActor;
import kh.gangnam.kickmovie.entity.MovieDetail;
import kh.gangnam.kickmovie.entity.MovieSearch;
import kh.gangnam.kickmovie.util.ApiUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApiEntity {

    private final ModelMapper modelMapper;
    private final ApiResponse apiResponse;
    private final ApiUtil apiUtil;

    // TODO Service 에서 검색어 한 번 들어왔을 때 저장해야 하는 데이터셋 지정
    public List<AllEntityDTO> responseApi(String url) throws JsonProcessingException {
        HttpHeaders headers = apiUtil.createHeaders();
        List<MovieSearchGenreDTO> movieSearchList = convertToEntity(
                apiResponse.searchListData(url, headers)
        );
        List<AllEntityDTO> allEntityDTOList = new ArrayList<>();
        for (MovieSearchGenreDTO dto : movieSearchList) {
            allEntityDTOList.add(setMovieEntity(dto, headers));
        }
        return allEntityDTOList;
    }

    // TODO AllEntityDTO movieSearch 한 개당 저장할 데이터셋
    private AllEntityDTO setMovieEntity(MovieSearchGenreDTO movieSearchGenreDTO, HttpHeaders headers) throws JsonProcessingException {

        String movie_id = String.valueOf(movieSearchGenreDTO.getMovieSearch().getMovieId());
        MovieDetail movieDetail = convertToEntity(
                apiResponse.detailData(
                        apiUtil.getDetailURL(movie_id), headers)
        );
        List<MovieActorInfoDTO> movieActorInfoDTOList = convertToEntity(
                apiResponse.actorListData(
                        apiUtil.getActorListURL(movie_id), headers)
        );
        return new AllEntityDTO(
                movieSearchGenreDTO.getMovieSearch(),
                movieSearchGenreDTO.getGenreResponseDTO(),
                movieDetail,
                movieActorInfoDTOList);
    }

    // TODO MovieSearchDTO MovieSearch 엔티티로 변환 후 엔티티 반환
    // MovieSearchDTO → List<MovieSearch>
    private List<MovieSearchGenreDTO> convertToEntity(MovieSearchDTO dto) throws JsonProcessingException {
        List<MovieSearchGenreDTO> movieSearchGenreDTOS = new ArrayList<>();
        for (SearchResultDTO resultDTO : dto.getResults()) {
            MovieSearch entity = modelMapper.map(resultDTO, MovieSearch.class);
            GenreResponseDTO genreResponseDTO = new GenreResponseDTO(
                    resultDTO.getMovieId(),
                    resultDTO.getGenre_ids()
            );
            movieSearchGenreDTOS.add(new MovieSearchGenreDTO(entity, genreResponseDTO));
        }
        return movieSearchGenreDTOS;

    }
    // TODO MovieDetailDTO MovieDetail 엔티티로 변환 후 엔티티 반환
    // MovieDetailDTO → MovieDetail
    private MovieDetail convertToEntity(MovieDetailDTO dto) throws JsonProcessingException {
        MovieDetail entity = modelMapper.map(dto, MovieDetail.class);
        return entity;
    }

    // TODO ActorDTO actor 엔티티로 변환 후 엔티티 반환
    // ActorDTO → List<Actor>
    private List<MovieActorInfoDTO> convertToEntity(ActorDTO dto) throws JsonProcessingException {
        List<MovieActorInfoDTO> dtoList = new ArrayList<>();
        for (CastDTO castDto : dto.getCast()) {
            Actor actor = modelMapper.map(castDto, Actor.class);
            MovieActor movieActor = modelMapper.map(castDto, MovieActor.class);
            MovieActorInfoDTO movieActorInfoDTO = new MovieActorInfoDTO(actor, movieActor);
            dtoList.add(movieActorInfoDTO);
        }
        return dtoList;
    }
}