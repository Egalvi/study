package ru.egalvi.problem.persistence.service;

import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.domain.Discipline;

/**
 *
 */
public interface DisciplineService {
    Discipline create(DisciplineDto created);
    Discipline delete(Long id) throws EntityNotFoundException;
    Iterable<Discipline> findAll();
    Discipline findById(Long id);
    Discipline update(DisciplineDto updated) throws EntityNotFoundException;
}
