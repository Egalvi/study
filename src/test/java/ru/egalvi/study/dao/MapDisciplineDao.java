package ru.egalvi.study.dao;

import ru.egalvi.study.model.Discipline;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapDisciplineDao implements DisciplineDao{
    private Map<Long, Discipline> disciplineMap = new HashMap<Long, Discipline>();

    public Collection<Discipline> getAll() {
        return disciplineMap.values();
    }

    public void save(Discipline discipline) {
        disciplineMap.put(discipline.getId(), discipline);
    }
}
