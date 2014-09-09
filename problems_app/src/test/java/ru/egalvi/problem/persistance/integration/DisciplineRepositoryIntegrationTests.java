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
    public void findByName() throws Exception {
        String name = "discipline1";

        Discipline discipline = new Discipline(name, null/*Arrays.asList(category)*/);

        long key = discipline.getId();

        disciplineRepository.save(discipline);

        Discipline retrievedDiscipline = disciplineRepository.findByName(name).get(0);

        assertNotNull(retrievedDiscipline);
        assertEquals(name, retrievedDiscipline.getName());
    }
}
