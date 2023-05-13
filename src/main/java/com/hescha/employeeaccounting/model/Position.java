package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
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
}
