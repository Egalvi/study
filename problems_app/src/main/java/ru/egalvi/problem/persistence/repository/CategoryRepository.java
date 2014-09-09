package ru.egalvi.problem.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import ru.egalvi.problem.persistence.domain.Category;

/**
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category getById(long id);
}
