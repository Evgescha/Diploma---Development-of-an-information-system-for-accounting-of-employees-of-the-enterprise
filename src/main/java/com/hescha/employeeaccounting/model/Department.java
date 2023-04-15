package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Department extends AbstractEntity {
    private String name;
    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    @ManyToOne
    private Employee manager;
}
