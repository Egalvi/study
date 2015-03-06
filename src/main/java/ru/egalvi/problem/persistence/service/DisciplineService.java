package ru.egalvi.problem.persistence.service;

import ru.egalvi.problem.core.domain.DisciplineDto;

/**
 *
 */
public interface DisciplineService {
    DisciplineDto create(DisciplineDto created);
    DisciplineDto delete(Long id) throws EntityNotFoundException;
    Iterable<DisciplineDto> findAll();
    DisciplineDto findById(Long id);
    DisciplineDto update(DisciplineDto updated) throws EntityNotFoundException;
}
