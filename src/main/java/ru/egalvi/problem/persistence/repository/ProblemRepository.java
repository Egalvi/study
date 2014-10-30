package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Problem;

import java.util.List;

/**
 *
 */
public interface ProblemRepository extends CrudRepository<Problem, Long> {
    //This method should be auto-created. See http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    List<Problem> findByTextContainingIgnoreCase(String text);
}
