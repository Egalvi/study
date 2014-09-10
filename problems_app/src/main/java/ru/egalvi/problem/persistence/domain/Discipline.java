package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;
import java.util.Collection;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline")
    private Collection<Category> categories;

    protected Discipline() {
    }

    public Discipline(String name, Collection<Category> categories) {
        this.name = name;
        this.categories = categories;
    }

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

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
