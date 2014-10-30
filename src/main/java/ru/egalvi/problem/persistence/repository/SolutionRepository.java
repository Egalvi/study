package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Solution;

/**
 *
 */
public interface SolutionRepository extends CrudRepository<Solution, Long> {
}
