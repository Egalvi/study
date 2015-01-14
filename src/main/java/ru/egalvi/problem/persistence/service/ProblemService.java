package ru.egalvi.problem.persistence.service;

import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.ProblemDto;

/**
 *
 */
public interface ProblemService {
    ProblemDto create(ProblemDto created);
    ProblemDto delete(Long id) throws EntityNotFoundException;
    Iterable<ProblemDto> findAll();
    ProblemDto findById(Long id);
    Iterable<ProblemDto> findByCategory(CategoryDto categoryDto);
    ProblemDto update(ProblemDto updated) throws EntityNotFoundException;
}
