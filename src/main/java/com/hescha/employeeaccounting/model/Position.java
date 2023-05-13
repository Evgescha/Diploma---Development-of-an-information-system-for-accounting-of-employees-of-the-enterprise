package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
public class Position extends AbstractEntity {
    private String title;
    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Position position = (Position) o;
        return Objects.equals(title, position.title) && Objects.equals(description, position.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, description);
    }
}
