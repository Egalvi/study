package ru.egalvi.problem.persistence.service;

import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.DisciplineDto;

/**
 *
 */
public interface CategoryService {
    CategoryDto create(CategoryDto created);
    CategoryDto delete(Long id) throws EntityNotFoundException;
    Iterable<CategoryDto> findAll();
    CategoryDto findById(Long id);
    Iterable<CategoryDto> findByDiscipline(DisciplineDto disciplineDto);
    CategoryDto update(CategoryDto updated) throws EntityNotFoundException;
}
