package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;
import java.util.List;

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

//    @ElementCollection(fetch = FetchType.EAGER, targetClass = ru.egalvi.problem.persistence.domain.Category.class)
//    @JoinTable(name = "category", joinColumns = @JoinColumn(name = "idparentcategory"))
//    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "problem")
    private List<Problem> problems;


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
