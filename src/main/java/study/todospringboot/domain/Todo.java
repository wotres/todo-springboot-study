package study.todospringboot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity // table 과 매칭되며 객체와 RDB 연결
@Table(name = "todo")
@Getter
@Setter
public class Todo {
    @Id // JPA Entity 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    @Column(name = "todo_id")
    private Long id;
    private String userName;
    private String task;
    private boolean checked;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;

    public Todo() {

    }
}
