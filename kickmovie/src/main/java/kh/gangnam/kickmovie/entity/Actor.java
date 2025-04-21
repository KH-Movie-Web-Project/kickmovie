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

    // 영화가 갱신될때마다 캐릭터 이름 변경되면 덮어씌워지므로 role 필드가 중간테이블에 있는게 어떤지
    @Column(name = "character_name")  // 예약어 피하기
    private String character;
    private String creditId;

    //이또한 덮어씌워져서 중간테이블로 옮기는게 좋아보임
    //private int order; -> order는 예약어라서 actorOrder 로 변환
    private int actorOrder;
}
