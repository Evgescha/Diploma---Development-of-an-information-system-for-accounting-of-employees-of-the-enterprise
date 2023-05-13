package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
public class Department extends AbstractEntity {
    private String name;
    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));

    @ManyToOne
    private Employee manager;
}
