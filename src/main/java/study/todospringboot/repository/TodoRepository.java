package study.todospringboot.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import study.todospringboot.domain.Todo;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자 주입
@Slf4j
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
        String sql = "select todo from Todo todo order by todo.createDate DESC";
        return em.createQuery(sql, Todo.class)
                .getResultList();
    }

    public int updateOneChecked(Long id, boolean checked) {
        return em.createQuery("update Todo todo set todo.checked = :checked where todo.id = :id")
                .setParameter("id", id)
                .setParameter("checked", checked)
                .executeUpdate();
    }

    public int deleteOne(Long id) {
        return em.createQuery("delete from Todo todo where todo.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public int deleteAll() {
        String sql = "delete from Todo";
        return em.createQuery(sql)
                .executeUpdate();
    }
}
