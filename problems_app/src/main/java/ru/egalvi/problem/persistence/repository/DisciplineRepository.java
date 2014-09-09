package ru.egalvi.problem.persistence.repository;

import ru.egalvi.problem.persistence.domain.Discipline;

/**
 *
 */
public interface DisciplineRepository {
    Discipline findById(long id);
}
