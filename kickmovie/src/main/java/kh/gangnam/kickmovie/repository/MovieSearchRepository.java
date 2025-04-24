package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.MovieSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieSearchRepository extends JpaRepository<MovieSearch, Long> {

    @Query("SELECT m FROM MovieSearch m JOIN m.genres g WHERE g.id = :genreId")
    List<MovieSearch> findByGenreId(Long genreId);
}
