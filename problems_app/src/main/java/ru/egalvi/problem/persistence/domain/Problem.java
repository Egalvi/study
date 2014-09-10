package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;
import java.io.File;

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

    protected Problem() {
    }

    public Problem(long id, String text) {
        this.id = id;
        this.text = text;
    }

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Discipline.class)
    @JoinColumn(name = "idcategory")
    private Category category;

    @Column(name = "solution")
    private File solution;
}
