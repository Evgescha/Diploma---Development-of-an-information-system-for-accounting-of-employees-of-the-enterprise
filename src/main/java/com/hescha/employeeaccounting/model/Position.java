package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Position extends AbstractEntity {
    private String title;
    @Column(length = 3000)
    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees;
}
