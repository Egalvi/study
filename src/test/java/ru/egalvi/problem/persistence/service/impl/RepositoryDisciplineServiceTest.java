package ru.egalvi.problem.persistence.service.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.egalvi.problem.core.domain.CategoryDto;
import ru.egalvi.problem.core.domain.DisciplineDto;
import ru.egalvi.problem.persistence.service.DisciplineService;
import ru.egalvi.problem.persistence.service.EntityNotFoundException;

import javax.annotation.Resource;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
public class RepositoryDisciplineServiceTest {

    public static final Long ID = 7L;
    public static final String NAME = "discipline";
    public static final String UPDATED_NAME = "discipline_updated";

    @Resource
    private DisciplineService repositoryDisciplineService;

    @Before
    public void setUp() throws Exception {
//        repositoryDisciplineService = new RepositoryDisciplineService();
//        DisciplineRepository disciplineRepositoryMock = Mockito.mock(DisciplineRepository.class);
//        repositoryDisciplineService.setDisciplineRepository(disciplineRepositoryMock);
    }

    @Test
    public void testCreate() throws Exception {
        //given
        DisciplineDto disciplineDto = getDto();

        //when
        repositoryDisciplineService.create(disciplineDto);

        //then
        Iterable<DisciplineDto> created = repositoryDisciplineService.findAll();
        boolean isPersisted = Iterables.filter(created, new Predicate<DisciplineDto>() {
            @Override
            public boolean apply(DisciplineDto input) {
                return input.getName().equals(NAME);
            }
        }).iterator().hasNext();
        Assert.assertTrue("Entity expected to be persisted", isPersisted);
    }

    @Test
    public void testDelete() throws Exception {
        //given
        DisciplineDto disciplineDto = getDto();

        //when
        DisciplineDto discipline = repositoryDisciplineService.create(disciplineDto);
        DisciplineDto deleted = repositoryDisciplineService.delete(discipline.getId());

        //then
        Assert.assertEquals("Created and deleted disciplines should be equal", discipline, deleted);
    }

    @Test(expected = EntityNotFoundException.class)
    public void testDeleteException() throws Exception {
        //given
        DisciplineDto disciplineDto = getDto();

        //when
        DisciplineDto discipline = repositoryDisciplineService.create(disciplineDto);
        DisciplineDto deleted = repositoryDisciplineService.delete(-1L);

        //then
        Assert.assertEquals("Created and deleted disciplines should be equal", discipline, deleted);
    }

    @Test
    public void testFindAll() throws Exception {
        //given
        DisciplineDto disciplineDto = getDto();

        //when
        DisciplineDto discipline1 = repositoryDisciplineService.create(disciplineDto);
        disciplineDto.setName(UPDATED_NAME);
        DisciplineDto discipline2 = repositoryDisciplineService.create(disciplineDto);
        Iterable<DisciplineDto> all = repositoryDisciplineService.findAll();

        //then
        Assert.assertTrue("Should contain discipline1", Iterables.contains(all, discipline1));
        Assert.assertTrue("Should contain discipline2", Iterables.contains(all, discipline2));
    }

    @Test
    public void testFindById() throws Exception {
        //given
        DisciplineDto disciplineDto = getDto();

        //when
        DisciplineDto discipline = repositoryDisciplineService.create(disciplineDto);
        DisciplineDto found = repositoryDisciplineService.findById(discipline.getId());

        //then
        Assert.assertEquals("Created and deleted disciplines should be equal", discipline, found);
    }

//    @Test
//    public void testUpdate() throws Exception {
//        //given
//        DisciplineDto disciplineDto = getDto();
//
//        //when
//        DisciplineDto discipline = repositoryDisciplineService.create(disciplineDto);
//        discipline.setName(UPDATED_NAME);
//        DisciplineDto found = repositoryDisciplineService.update(discipline);
//
//        //then
//        Assert.assertNotEquals("Created and deleted disciplines should be equal", discipline, found);
//        Assert.assertEquals("Created and deleted disciplines should be equal", UPDATED_NAME, found.getName());
//    }

    private DisciplineDto getDto() {
        DisciplineDto disciplineDto = new DisciplineDto();
        disciplineDto.setName(NAME);
        disciplineDto.setCategories(Collections.<CategoryDto>emptyList());
        return disciplineDto;
    }
}