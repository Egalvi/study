package ru.egalvi.problem.persistence.domain;

import javax.persistence.*;

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

//    @Column(name = "idcategory")
//    private Category category;

//    @Column(name = "solution")
//    private File solution;
}
