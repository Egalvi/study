package ru.egalvi.problem.persistence.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 */
//@Embeddable
@Entity(name = "category")
public final class Category {
    @Id
    @Column(name = "idcategory")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

//    @ManyToOne//(fetch = FetchType.EAGER, targetEntity = Discipline.class)
//    @JoinColumn(name = "iddiscipline")
//    private Discipline discipline;

    //This is an example of self one-to-many bidirectional relation.
    //Parent-children relation is implemented here.
//    @ManyToOne
//    @JoinColumn(name = "idparentcategory")
//    private Category parent;

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "parent"*/)
    private Collection<Category> children;

    @OneToMany(cascade = CascadeType.ALL/*, mappedBy = "category"*/)
    private Collection<Problem> problems;

    protected Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Discipline getDiscipline() {
//        return discipline;
//    }
//
//    public void setDiscipline(Discipline discipline) {
//        this.discipline = discipline;
//    }

//    public Category getParent() {
//        return parent;
//    }
//
//    public void setParent(Category parent) {
//        this.parent = parent;
//    }

    public Collection<Category> getChildren() {
        return children;
    }

    public void setChildren(Collection<Category> children) {
        this.children = children;
    }

    public Collection<Problem> getProblems() {
        return problems;
    }

    public void setProblems(Collection<Problem> problems) {
        this.problems = problems;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
