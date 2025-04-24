package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.MovieSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieSearchRepository extends JpaRepository<MovieSearch, Long> {
    @Query("SELECT ms FROM MovieSearch ms LEFT JOIN FETCH ms.genres WHERE ms.title LIKE %:query%")
    List<MovieSearch> findByTitleContainingWithGenres(@Param("query") String query);

    @Query("SELECT m FROM MovieSearch m JOIN m.genres g WHERE g.id = :genreId")
    List<MovieSearch> findByGenreId(Long genreId);
}
