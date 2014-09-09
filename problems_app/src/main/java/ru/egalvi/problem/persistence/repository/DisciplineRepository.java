package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Discipline;

import java.util.List;

/**
 *
 */
public interface DisciplineRepository  extends CrudRepository<Discipline, Long> {
    Discipline findById(long id);
    List<Discipline> findByName(String name);
}
