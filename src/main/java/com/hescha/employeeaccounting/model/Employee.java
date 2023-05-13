package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class Employee extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String phoneNumber;
    private String email;

    @ManyToOne
    private Position position;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "employee")
    private Set<Vacation> vacations;

    @OneToMany(mappedBy = "employee")
    private Set<SickLeave> sickLeaves;

    @OneToMany(mappedBy = "employee")
    private Set<Training> trainings;

    @ManyToOne
    private Role userRole;
}
