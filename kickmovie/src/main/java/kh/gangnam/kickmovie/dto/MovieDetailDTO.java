package kh.gangnam.kickmovie.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailDTO {

    private boolean adult;
    @JsonProperty("belongs_to_collection")
    private BelongsToCollectionDTO belongsToCollection;
    private int budget;
    private List<GenreDTO> genres;
    @JsonProperty("homepage")
    private String homePage;
    @JsonProperty("imdb_id")
    private String imdbId;
    @JsonProperty("origin_country")
    private List<String> originCountry;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    private Double popularity;
    @JsonProperty("production_companies")
    private List<ProductionCompanyDTO> productionCompanies;
    @JsonProperty("production_countries")
    private List<ProductionCountryDTO> productionCountries;
    @JsonProperty("release_date")
    private String releaseDate;
    private int revenue;
    private int runtime;
    @JsonProperty("spoken_languages")
    private List<SpokenLanguageDTO> spokenLanguages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    @JsonProperty("vote_average")
    private Double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
}
