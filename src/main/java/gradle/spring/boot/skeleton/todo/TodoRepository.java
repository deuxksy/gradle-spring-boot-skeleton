package gradle.spring.boot.skeleton.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TodoRepository extends JpaRepository<Todo, Long>, QuerydslPredicateExecutor<Todo> {
}
