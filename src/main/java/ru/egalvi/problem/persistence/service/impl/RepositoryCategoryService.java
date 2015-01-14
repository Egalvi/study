package ru.egalvi.problem.persistence.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.egalvi.problem.config.OrikaMappings;
import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.domain.Category;
import ru.egalvi.problem.persistence.repository.CategoryRepository;
import ru.egalvi.problem.persistence.service.CategoryService;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class RepositoryCategoryService implements CategoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryCategoryService.class);

    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private OrikaMappings orikaMappings;

    @Override
    public CategoryDto create(CategoryDto created) {
        LOGGER.debug(created.toString());
        return orikaMappings.getMapper()
                .map(categoryRepository.save(orikaMappings.getMapper().map(created, Category.class)),
                        CategoryDto.class);
    }

    @Override
    public CategoryDto delete(Long id) throws EntityNotFoundException {
        LOGGER.debug("Deleting category with id: " + id);
        Category deleted = categoryRepository.findOne(id);
        if (deleted == null) {
            LOGGER.debug("No discipline with id: " + id);
            throw new EntityNotFoundException("No discipline with id: " + id);
        }
        categoryRepository.delete(deleted);
        return orikaMappings.getMapper().map(deleted, CategoryDto.class);
    }

    @Override
    public Iterable<CategoryDto> findAll() {
        LOGGER.debug("Selecting all categories");
        return orikaMappings.getMapper().mapAsList(categoryRepository.findAll(), CategoryDto.class);
    }

    @Override
    public CategoryDto findById(Long id) {
        LOGGER.debug("Finding category by id: " + id);
        return orikaMappings.getMapper().map(categoryRepository.findOne(id), CategoryDto.class);
    }

    @Override
    public Iterable<CategoryDto> findByDiscipline(DisciplineDto disciplineDto) {
        //TODO implement!
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto updated) throws EntityNotFoundException {
        LOGGER.debug("Updating category with information: " + updated);

        Category category = categoryRepository.findOne(updated.getId());

        if (category == null) {
            LOGGER.debug("No person found with id: " + updated.getId());
            throw new EntityNotFoundException("No person found with id: " + updated.getId());
        }

        Category saved = categoryRepository.save(orikaMappings.getMapper().map(updated, Category.class));

        return orikaMappings.getMapper().map(saved, CategoryDto.class);
    }
}
