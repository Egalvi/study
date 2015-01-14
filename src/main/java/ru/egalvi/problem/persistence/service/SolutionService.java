package ru.egalvi.problem.persistence.service;

import ru.egalvi.problem.core.domain.ProblemDto;
import ru.egalvi.problem.core.domain.SolutionDto;

/**
 *
 */
public interface SolutionService {
    SolutionDto create(SolutionDto created);
    SolutionDto delete(Long id) throws EntityNotFoundException;
    Iterable<SolutionDto> findAll();
    Iterable<SolutionDto> findByProblem(ProblemDto problemDto);
    SolutionDto findById(Long id);
    SolutionDto update(SolutionDto updated) throws EntityNotFoundException;
}
