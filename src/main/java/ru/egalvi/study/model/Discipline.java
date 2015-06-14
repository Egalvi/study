package ru.egalvi.study.model;

import java.util.List;

public class Discipline {
    long id;
    private List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
