package kh.gangnam.kickmovie.entity;

import kh.gangnam.kickmovie.dto.*;

import java.util.List;

public class MovieDetail {

    private long id;
    private boolean adult;
    private BelongsToCollectionDTO belongsToCollection;
    private int budget;
    private List<GenreDTO> genres;
    private String homePage;
    private String imdbId;
    private List<String> originCountry;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private Double popularity;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private Double voteAverage;
    private int voteCount;
    private String releaseDate;
    //    private List<SpokenLanguageDTO> spokenLanguages;
    //    private List<ProductionCompanyDTO> productionCompanies;
    //    private List<ProductionCountryDTO> productionCountries;
}
