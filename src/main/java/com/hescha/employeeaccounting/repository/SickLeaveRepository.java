package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.SickLeave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SickLeaveRepository extends JpaRepository<SickLeave, Long> {
    SickLeave findByStartDate(LocalDate startDate);

    SickLeave findByDuration(int duration);

    SickLeave findByEmployee(Employee employee);
}
