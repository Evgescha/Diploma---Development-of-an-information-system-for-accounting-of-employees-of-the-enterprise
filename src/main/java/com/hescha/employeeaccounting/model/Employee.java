package com.hescha.employeeaccounting.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
public class Employee extends AbstractEntity {
    private String firstName;
    private String lastName;
    private String middleName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate = LocalDate.now();
    private String phoneNumber;
    private String email;
    private String image;

    @ManyToOne
    private Position position;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "employee")
    private Set<Vacation> vacations = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));

    @OneToMany(mappedBy = "employee")
    private Set<SickLeave> sickLeaves = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));

    @ManyToMany(mappedBy = "employee")
    private Set<Training> trainings = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));

    @ManyToOne
    private Role role;
}
