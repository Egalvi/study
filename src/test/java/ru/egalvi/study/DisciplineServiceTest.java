package ru.egalvi.study;

import org.junit.Before;
import org.junit.Test;
import ru.egalvi.study.dao.MapDisciplineDao;
import ru.egalvi.study.model.Discipline;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DisciplineServiceTest {
    DisciplineService disciplineService;

    @Before
    public void setUp() throws Exception {
        disciplineService = new DisciplineService(new MapDisciplineDao());

    }

    @Test
    public void canCallGetDisciplines() throws Exception {
        disciplineService.getAll();
    }

    @Test
    public void canSave() throws Exception {
        disciplineService.save(new Discipline());
    }

    @Test
    public void canSaveAndRetrieve() throws Exception {
        Discipline discipline = new Discipline();
        disciplineService.save(discipline);
        Collection<Discipline> all = disciplineService.getAll();
        assertTrue(all.contains(discipline));
    }

    @Test
    public void canSaveMultiple() throws Exception {
        Discipline discipline = new Discipline();
        discipline.setId(1l);
        disciplineService.save(discipline);
        discipline = new Discipline();
        discipline.setId(2l);
        disciplineService.save(discipline);
        Collection<Discipline> all = disciplineService.getAll();
        assertEquals(2, all.size());
    }
}
