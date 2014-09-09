package ru.egalvi.problem.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 */
@Entity(name = "problem")
public final class Problem {
    @Id
    @Column(name = "idproblem")
    private long id;

    @Column(name = "text")
    private String text;

//    @Column(name = "idcategory")
//    private Category category;

//    @Column(name = "solution")
//    private File solution;
}
