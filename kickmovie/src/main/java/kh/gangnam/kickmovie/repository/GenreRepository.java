package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
