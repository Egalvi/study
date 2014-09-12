package ru.egalvi.problem.persistance.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.egalvi.problem.config.JPAConfiguration;

import javax.persistence.EntityManager;

import static ru.egalvi.problem.persistance.domain.fixture.JPAAssertions.assertTableExists;
import static ru.egalvi.problem.persistance.domain.fixture.JPAAssertions.assertTableHasColumn;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class EntityMappingIntegrationTests {
    @Autowired
    EntityManager manager;

    @Test
    public void disciplineMapping() throws Exception {
        assertTableExists(manager, "discipline");

        assertTableHasColumn(manager, "discipline", "iddiscipline");
        assertTableHasColumn(manager, "discipline", "name");
    }

    @Test
    public void categoryMapping(){
        assertTableExists(manager, "category");

        assertTableHasColumn(manager, "category", "idcategory");
        assertTableHasColumn(manager, "category", "name");
        assertTableHasColumn(manager, "category", "iddiscipline");
        assertTableHasColumn(manager, "category", "idparentcategory");
    }

    @Test
    public void problemMapping(){
        assertTableExists(manager, "problem");

        assertTableHasColumn(manager, "problem", "idproblem");
        assertTableHasColumn(manager, "problem", "text");
        assertTableHasColumn(manager, "problem", "idcategory");
    }

    @Test
    public void solutionMapping(){
        assertTableExists(manager, "solution");

        assertTableHasColumn(manager, "solution", "idsolution");
        assertTableHasColumn(manager, "solution", "name");
        assertTableHasColumn(manager, "solution", "comment");
        assertTableHasColumn(manager, "solution", "page_num");
        assertTableHasColumn(manager, "solution", "file");
        assertTableHasColumn(manager, "solution", "idproblem");
    }
}
