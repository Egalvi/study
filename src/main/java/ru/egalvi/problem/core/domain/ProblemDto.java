package ru.egalvi.problem.core.domain;

import java.io.File;

/**
 *
 */
public final class ProblemDto {
    private Long id;
    private String text;
    private CategoryDto category;
    private File solution;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public File getSolution() {
        return solution;
    }

    public void setSolution(File solution) {
        this.solution = solution;
    }
}
