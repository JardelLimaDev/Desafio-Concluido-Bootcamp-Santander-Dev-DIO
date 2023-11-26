package dio.desafio.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String score;
    @Column
    private String limitScore;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLimitScore() {
        return limitScore;
    }

    public void setLimitScore(String limitScore) {
        this.limitScore = limitScore;
    }
}
