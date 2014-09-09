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
public class OrderMappingIntegrationTests {
    @Autowired
    EntityManager manager;

    @Test
    public void thatItemCustomMappingWorks() throws Exception {
        assertTableExists(manager, "discipline");
//        assertTableExists(manager, "category");
//        assertTableExists(manager, "problem");

        assertTableHasColumn(manager, "discipline", "iddiscipline");
        assertTableHasColumn(manager, "discipline", "name");
    }
}
