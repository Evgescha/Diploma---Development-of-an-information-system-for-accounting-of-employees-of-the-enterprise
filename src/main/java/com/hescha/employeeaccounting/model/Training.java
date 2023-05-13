package com.hescha.employeeaccounting.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Data
public class Training extends AbstractEntity {
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate = LocalDate.now();
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate = LocalDate.now();
    @Column(length = 3000)
    private String result;

    @ManyToMany
    private Set<Employee> employee = new TreeSet<>((o1, o2) -> o1.id.compareTo(o2.getId()));
}
