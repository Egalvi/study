package ru.egalvi.study.model;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    long id;
    private List<Category> categories = new ArrayList<>();

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
