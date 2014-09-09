package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;
import java.util.List;

/**
 *
 */
@Entity(name = "discipline")
public final class Discipline {
    @Id
    @Column(name = "iddiscipline")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = ru.egalvi.problem.persistence.domain.Category.class)
    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "iddiscipline"))
    private List<Category> categories;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
