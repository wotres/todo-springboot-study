package study.todospringboot.controller;

import java.time.LocalDateTime;

public class TodoResponse {
    private Long id;
    private String userId;
    private String task;
    private LocalDateTime updateDate;
    private LocalDateTime createDate;

    public TodoResponse(Long id, String userId, String task, LocalDateTime updateDate, LocalDateTime createDate) {
    }
}
