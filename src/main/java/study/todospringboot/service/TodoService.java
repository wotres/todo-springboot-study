package study.todospringboot.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.todospringboot.domain.Todo;
import study.todospringboot.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public String save(Todo todo) {
        todoRepository.save(todo);
        if (todo.getId() > 0) {
            return "success";
        }
        return "fail";
    }

    public List<Todo> findAll(String orderType) {
        return todoRepository.findAll(orderType);
    }

    public Todo findOne(Long todoId) {
        return todoRepository.findOne(todoId);
    }

    @Transactional
    public String updateOneChecked(Long todoId, boolean checked) {
        int result = todoRepository.updateOneChecked(todoId, checked);
        if (result >=0) {
            return "success";
        }
        return "fail";
    }

    public int deleteOne(Long todoId) {
        return todoRepository.deleteOne(todoId);
    }

    @Transactional
    public String deleteAll() {
        int result = todoRepository.deleteAll();
        if (result >=0) {
            return "success";
        }
        return "fail";
    }
}
