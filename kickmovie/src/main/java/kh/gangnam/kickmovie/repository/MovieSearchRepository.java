package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.MovieSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSearchRepository extends JpaRepository<MovieSearch, Long> {
}
