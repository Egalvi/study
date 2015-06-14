package ru.egalvi.study.dao;

import ru.egalvi.study.model.Discipline;

import java.util.Collection;

public interface DisciplineDao {
    Collection<Discipline> getAll();
    void save(Discipline discipline);
}
