package ru.egalvi.study.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private List<Problem> problems = new ArrayList<>();

    public List<Problem> getProblems() {
        return problems;
    }
}
