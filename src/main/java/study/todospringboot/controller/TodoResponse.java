package study.todospringboot.controller;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponse {
    private final Long id;
    private final String userName;
    private final String task;
    private final boolean checked;
    private final LocalDateTime updateDate;
    private final LocalDateTime createDate;

    public TodoResponse(final Long id, final String userName, final String task, final boolean checked, final LocalDateTime updateDate, final LocalDateTime createDate) {
        this.id = id;
        this.userName = userName;
        this.task = task;
        this.checked = checked;
        this.updateDate = updateDate;
        this.createDate = createDate;
    }
}
