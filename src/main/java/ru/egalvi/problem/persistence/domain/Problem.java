package ru.egalvi.problem.persistence.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Collection;

/**
 *
 */
@Entity(name = "problem")
public final class Problem {
    @Id
    @Column(name = "idproblem")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "text")
    private String text;

//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Discipline.class)
//    @JoinColumn(name = "idcategory")
//    private Category category;

    @OneToMany(cascade = CascadeType.ALL)//(mappedBy = "problem")
    private Collection<Solution> solution;

    protected Problem() {
    }

    public Problem(long id, String text) {
        this.id = id;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public Collection<Solution> getSolution() {
        return solution;
    }

    public void setSolution(Collection<Solution> solution) {
        this.solution = solution;
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
