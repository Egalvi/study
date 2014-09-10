package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 */
@Entity(name = "category")
public final class Category {
    @Id
    @Column(name = "idcategory")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Discipline.class)
    @JoinColumn(name = "iddiscipline")
    private Discipline discipline;

    //This is an example of self one-to-many bidirectional relation.
    //Parent-children relation is implemented here.
    @ManyToOne
    @JoinColumn(name = "idparentcategory")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private Collection<Category> children;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Collection<Problem> problems;


    protected Category() {
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
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
}
