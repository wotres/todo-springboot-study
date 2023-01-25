package study.todospringboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import study.todospringboot.domain.Todo;
import study.todospringboot.service.TodoService;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
@Slf4j
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody TodoRequest todoRequest) {
        return todoService.save(toTodo(todoRequest));
    }

    @GetMapping("/{orderType}")
    public List<TodoResponse> findAll(@PathVariable("orderType") String orderType) {
        return toTodoResponseList(todoService.findAll(orderType));
    }

    @GetMapping("/task/{id}")
    public TodoResponse findOne(@PathVariable("id") final Long id) {
        return toTodoResponse(todoService.findOne(id));
    }

    @PatchMapping()
    public String updateOneChecked(
            @RequestBody TodoChangeCheckRequest todoChangeCheckRequest
    ) {
        return todoService.updateOneChecked(todoChangeCheckRequest.getId(), todoChangeCheckRequest.isChecked());
    }

    @DeleteMapping("/{id}")
    public int deleteOne(@PathVariable("id") final Long id) {
        return todoService.deleteOne(id);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAll() {
        return todoService.deleteAll();
    }

    private Todo toTodo(TodoRequest todoRequest) {
        Todo todo = new Todo();
        todo.setUserName(todoRequest.getUserId());
        todo.setTask(todoRequest.getTask());
        todo.setUpdateDate(LocalDateTime.now());
        todo.setCreateDate(LocalDateTime.now());
        return todo;
    }

    private List<TodoResponse> toTodoResponseList(List<Todo> todoList) {
        return todoList.stream().map(this::toTodoResponse).toList();
    }

    private TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(
            todo.getId(),
            "noName",
            todo.getTask(),
            todo.isChecked(),
            todo.getUpdateDate(),
            todo.getCreateDate()
        );
    }
}
