package ru.egalvi.problem.persistance.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.egalvi.problem.config.JPAConfiguration;
import ru.egalvi.problem.persistence.domain.Discipline;
import ru.egalvi.problem.persistence.repository.DisciplineRepository;

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

    @Test
    public void thatItemIsInsertedIntoRepoWorks() throws Exception {
        long key = 1l;

//        Category category = new Category(1l,"cat1");
        Discipline discipline = new Discipline(key,"discipline1",null/*Arrays.asList(category)*/);

        disciplineRepository.save(discipline);

        Discipline retrievedDiscipline = disciplineRepository.findById(key);

        assertNotNull(retrievedDiscipline);
        assertEquals(key, retrievedDiscipline.getId());
        assertEquals("discipline1", retrievedDiscipline.getName());
    }

}
