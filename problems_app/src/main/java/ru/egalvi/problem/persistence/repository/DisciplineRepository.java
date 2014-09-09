package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Discipline;

/**
 *
 */
public interface DisciplineRepository  extends CrudRepository<Discipline, Long> {
    Discipline findById(long id);
}
