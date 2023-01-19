package study.todospringboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.todospringboot.domain.Todo;
import study.todospringboot.service.TodoService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/save")
    public Long save(@RequestBody TodoRequest todoRequest) {
        return todoService.save(toTodo(todoRequest));
    }

    @GetMapping("/{orderType}")
    public List<TodoResponse> findAll(@PathVariable("orderType") String orderType) {
        return toTodoResponseList(todoService.findAll(orderType));
    }

    @GetMapping("/{id}")
    public TodoResponse findOne(@PathVariable("id") final Long id) {
        return toTodoResponse(todoService.findOne(id));
    }

    @GetMapping(params = {"id", "task"})
    public int updateOne(
            @PathVariable("id") final Long id,
            @PathVariable("task") final String task
    ) {
        return todoService.updateOne(id, task);
    }

    @DeleteMapping("/{id}")
    public int deleteOne(@PathVariable("id") final Long id) {
        return todoService.deleteOne(id);
    }

    @DeleteMapping
    public int deleteAll() {
        return todoService.deleteAll();
    }

    private Todo toTodo(TodoRequest todoRequest) {
        return new Todo(
                todoRequest.getUserId(),
                todoRequest.getTask(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    private List<TodoResponse> toTodoResponseList(List<Todo> todoList) {
        return todoList.stream().map(todo ->
                new TodoResponse(
                    todo.getId(),
                    todo.getUserId(),
                    todo.getTask(),
                    todo.getUpdateDate(),
                    todo.getCreateDate()
                )
        ).toList();
    }

    private TodoResponse toTodoResponse(Todo todo) {
        return new TodoResponse(
            todo.getId(),
            todo.getUserId(),
            todo.getTask(),
            todo.getUpdateDate(),
            todo.getCreateDate()
        );
    }
}
