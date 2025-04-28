package kh.gangnam.kickmovie.config;

import kh.gangnam.kickmovie.dto.CastDTO;
import kh.gangnam.kickmovie.entity.MovieActor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // ❗️ 충돌 무시 설정 먼저
        modelMapper.getConfiguration().setAmbiguityIgnored(true);

        // ID 매핑 제외
        modelMapper.typeMap(CastDTO.class, MovieActor.class)
                .addMappings(mapper -> mapper.skip(MovieActor::setId));
        return modelMapper;
    }
}
