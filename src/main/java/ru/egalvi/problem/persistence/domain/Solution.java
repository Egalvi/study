package ru.egalvi.problem.persistence.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.File;

/**
 *
 */
@Entity(name = "solution")
public class Solution {
    @Id
    @Column(name = "idsolution")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "page_num")
    private int pageNum;

    @Column(name = "file")
    private File file;

//    @ManyToOne(targetEntity = Problem.class)
//    @JoinColumn(name = "idproblem")
//    private Problem problem;

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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

//    public Problem getProblem() {
//        return problem;
//    }
//
//    public void setProblem(Problem problem) {
//        this.problem = problem;
//    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
