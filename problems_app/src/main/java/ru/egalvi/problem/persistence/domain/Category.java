package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;

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

//    @Column(name = "iddiscipline")
//    private Discipline discipline;

//    @ElementCollection(fetch = FetchType.EAGER, targetClass = ru.egalvi.problem.persistence.domain.Category.class)
//    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "idparentcategory"))
//    private List<Category> categories;

//    @ElementCollection(fetch = FetchType.EAGER, targetClass = ru.egalvi.problem.persistence.domain.Category.class)
//    @JoinTable(name = "problem", joinColumns = @JoinColumn(name = "idcategory"))
//    private List<Problem> problems;


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
