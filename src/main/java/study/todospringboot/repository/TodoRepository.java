package study.todospringboot.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.todospringboot.domain.OrderType;
import study.todospringboot.domain.Todo;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자 주입
public class TodoRepository {
    private final EntityManager em;

    public void save(Todo todo) {
        em.persist(todo);
    }

    public Todo findOne(Long id) {
        return em.find(Todo.class, id);
    }

    public List<Todo> findAll(String orderType) {
//        if (OrderType.ASC.equals(orderType)) {
//            return em.createQuery("select todo from Todo todo order by todo.createDate ASC", Todo.class)
//                    .getResultList();
//        }
        return em.createQuery("select todo from Todo todo order by todo.createDate DESC", Todo.class)
                .getResultList();
    }

    public int updateOne(Long id, String task) {
        return em.createQuery("update Todo todo set todo.task = :task where todo.id = :id")
                .setParameter("id", id)
                .setParameter("task", task)
                .executeUpdate();
    }

    public int deleteOne(Long id) {
        return em.createQuery("delete from Todo todo where todo.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public int deleteAll() {
        return em.createQuery("delete from Todo").executeUpdate();
    }
}
