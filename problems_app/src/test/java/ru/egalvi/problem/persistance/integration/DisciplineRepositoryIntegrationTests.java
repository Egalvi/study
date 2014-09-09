package ru.egalvi.problem.persistance.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.egalvi.problem.config.JPAConfiguration;
import ru.egalvi.problem.persistence.domain.Category;
import ru.egalvi.problem.persistence.domain.Discipline;
import ru.egalvi.problem.persistence.repository.CategoryRepository;
import ru.egalvi.problem.persistence.repository.DisciplineRepository;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class DisciplineRepositoryIntegrationTests {

    @Autowired
    DisciplineRepository disciplineRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void thatItemIsInsertedIntoRepoWorks() throws Exception {
        long key = 1l;

        Discipline discipline = new Discipline();
        discipline.setId(key);
        discipline.setName("discipline1");

        Category category = new Category();
        category.setId(1l);
        List<Category> categories = Arrays.asList(category);

        categoryRepository.save(category);

        discipline.setCategories(categories);

        disciplineRepository.save(discipline);

        Discipline retrievedDiscipline = disciplineRepository.findById(key);

        assertNotNull(retrievedDiscipline);
        assertEquals(key, retrievedDiscipline.getId());
        assertEquals("discipline1", retrievedDiscipline.getName());
    }

}
