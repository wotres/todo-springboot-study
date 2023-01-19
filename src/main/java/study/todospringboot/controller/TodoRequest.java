package study.todospringboot.controller;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoRequest {
    private String userId;
    private String task;
    private LocalDateTime createDate;
}
