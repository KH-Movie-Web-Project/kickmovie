package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.MovieDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDetailRepository extends JpaRepository<MovieDetail, Long> {
}
