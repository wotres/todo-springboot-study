package study.todospringboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.todospringboot.domain.Todo;
import study.todospringboot.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Long save(Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> findAll(String orderType) {
        return todoRepository.findAll(orderType);
    }

    public Todo findOne(Long todoId) {
        return todoRepository.findOne(todoId);
    }

    public int updateOne(Long todoId, String task) {
        return todoRepository.updateOne(todoId, task);
    }

    public int deleteOne(Long todoId) {
        return todoRepository.deleteOne(todoId);
    }

    public int deleteAll() {
        return todoRepository.deleteAll();
    }
}
