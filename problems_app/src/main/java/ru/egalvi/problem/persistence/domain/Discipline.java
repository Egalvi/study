package ru.egalvi.problem.persistence.domain;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import ru.egalvi.problem.core.domain.CategoryDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 */
@Entity
@Table(name = "discipline")
public final class Discipline {
    @Id
    @Column(name = "iddiscipline")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discipline")
    private Collection<Category> categories;

    protected Discipline() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    private void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * A Builder for the Discipline class.
     */
    public static class Builder {
        private Long id;
        private String name;
        private Collection<Category> categories;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCategories(Collection<Category> categories) {
            this.categories = categories;
            return this;
        }

        public Builder setCategoriesFromModel(Collection<CategoryDto> categories){
            this.categories= Collections2.transform(categories,new Function<CategoryDto, Category>() {
                @Override
                public Category apply(CategoryDto input) {
                    return new Category(input.getId(),input.getName());
                }
            });
            return this;
        }

        public Discipline build() {
            if (name == null) {
                throw new IllegalStateException("Discipline name must be specified");
            }
            Discipline discipline = new Discipline();
            discipline.setName(name);
            discipline.setCategories(new ArrayList<Category>(categories));
            return discipline;
        }

        public Builder update(Discipline toUpdate){
            id=toUpdate.getId();
            name=toUpdate.getName();
            categories=toUpdate.getCategories();
            return this;
        }
    }
}
