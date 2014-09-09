package ru.egalvi.problem.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */
@Entity(name = "category")
public final class Category {
    @Id
    @Column(name = "idcategory")
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
}
