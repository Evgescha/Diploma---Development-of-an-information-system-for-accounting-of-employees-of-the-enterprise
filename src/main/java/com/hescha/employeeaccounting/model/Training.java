package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class Training extends AbstractEntity {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(length = 3000)
    private String result;

    @ManyToOne
    private Employee employee;
}
