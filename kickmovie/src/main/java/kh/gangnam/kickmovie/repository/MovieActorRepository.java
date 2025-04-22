package kh.gangnam.kickmovie.repository;

import kh.gangnam.kickmovie.entity.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieActorRepository extends JpaRepository<MovieActor, Long> {
}
