package study.todospringboot.controller;

import lombok.Getter;

@Getter
public class TodoChangeCheckRequest {
    private Long id;
    private boolean checked;
}
