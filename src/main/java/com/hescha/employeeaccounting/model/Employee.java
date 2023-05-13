package com.hescha.employeeaccounting.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
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

    @Override
    public String toString() {
        return id + " - " + lastName + " " + firstName + " " + middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName) && Objects.equals(birthDate, employee.birthDate) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(email, employee.email) && Objects.equals(image, employee.image) && Objects.equals(position, employee.position) && Objects.equals(department, employee.department) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, middleName, birthDate, phoneNumber, email, image, position, department, role);
    }
}
