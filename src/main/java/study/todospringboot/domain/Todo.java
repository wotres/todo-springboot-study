package study.todospringboot.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity // table 과 매칭되며 객체와 RDB 연결
@Table(name = "todos")
@Getter
public class Todo {
    @Id // JPA Entity 식별자
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성을 데이터베이스에 위임
    @Column(name = "todo_id")
    private Long id;
    private String userId;
    private String task;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;

    public Todo(String userId, String task, LocalDateTime updateDate, LocalDateTime createDate) {
    }

    public Todo() {

    }
}
