package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class SickLeave extends AbstractEntity {
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration;

    @ManyToOne
    private Employee employee;
}
