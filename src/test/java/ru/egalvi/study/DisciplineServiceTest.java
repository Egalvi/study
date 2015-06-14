package ru.egalvi.study;

import com.google.common.collect.Collections2;
import org.junit.Before;
import org.junit.Test;
import ru.egalvi.study.dao.MapDisciplineDao;
import ru.egalvi.study.model.Category;
import ru.egalvi.study.model.Discipline;
import ru.egalvi.study.model.Problem;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisciplineServiceTest {
    DisciplineService disciplineService;

    @Before
    public void setUp() throws Exception {
        disciplineService = new DisciplineService(new MapDisciplineDao());

    }

    @Test
    public void canSaveAndRetrieve() throws Exception {
        Discipline discipline = getDiscipline();
        disciplineService.save(discipline);
        Collection<Discipline> all = disciplineService.getAll();
        assertTrue(all.contains(discipline));
    }

    @Test
    public void canSaveMultiple() throws Exception {
        Discipline discipline = getDiscipline();
        disciplineService.save(discipline);
        discipline = getAnotherDiscipline();
        disciplineService.save(discipline);
        Collection<Discipline> all = disciplineService.getAll();
        assertEquals(2, all.size());
    }

    @Test
    public void canSaveCategories() throws Exception {
        Discipline discipline = getDiscipline();
        List<Category> categories = discipline.getCategories();
        assertFalse(categories.isEmpty());

        disciplineService.save(discipline);

        assertFalse(Collections2.filter(disciplineService.getAll(), discipl -> !discipl.getCategories().isEmpty()).isEmpty());

    }

    @Test
    public void canGetProblems() throws Exception {
        Discipline discipline = getDiscipline();
        List<Problem> problems = discipline.getCategories().get(0).getProblems();
        assertFalse(problems.isEmpty());
    }

    private Discipline getAnotherDiscipline() {
        Discipline discipline = new Discipline();
        discipline.setId(2l);
        return discipline;
    }

    private Discipline getDiscipline() {
        Discipline discipline = new Discipline();
        discipline.setId(1l);
        Category category = new Category();
        Problem problem = new Problem();
        category.getProblems().add(problem);
        discipline.getCategories().add(category);
        return discipline;
    }
}
