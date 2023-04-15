package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Vacation extends AbstractEntity {
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration;
    private VacationStatus status = VacationStatus.CREATED;

    @ManyToOne
    private Employee employee;
}
