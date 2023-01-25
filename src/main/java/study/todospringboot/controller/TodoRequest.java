package study.todospringboot.controller;

import lombok.Getter;

@Getter
public class TodoRequest {
    private String userId;
    private String task;
}
