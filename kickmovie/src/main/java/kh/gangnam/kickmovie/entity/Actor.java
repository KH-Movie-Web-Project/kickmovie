package kh.gangnam.kickmovie.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Actor {
    @Id
    private Long actorId;
    private boolean adult;
    private int gender;
    private String knownForDepartment;
    private String name;
    private String originalName;
    private Double popularity;
    private String profilePath;
    private int castId;

    @Column(name = "character_name")  // 예약어 피하기
    private String character;
    private String creditId;

    //private int order; -> order는 예약어라서 actorOrder 로 변환
    private int actorOrder;
}
