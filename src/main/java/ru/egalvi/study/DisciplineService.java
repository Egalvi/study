package ru.egalvi.study;

import ru.egalvi.study.dao.DisciplineDao;
import ru.egalvi.study.model.Discipline;

import java.util.Collection;

public class DisciplineService {

    private DisciplineDao disciplineDao;

    public DisciplineService(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    public Collection<Discipline> getAll() {
        return disciplineDao.getAll();
    }

    public void save(Discipline discipline) {
        disciplineDao.save(discipline);
    }
}
