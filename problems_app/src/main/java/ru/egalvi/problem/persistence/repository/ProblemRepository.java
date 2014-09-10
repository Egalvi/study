package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Problem;

/**
 *
 */
public interface ProblemRepository extends CrudRepository<Problem, Long> {
}
