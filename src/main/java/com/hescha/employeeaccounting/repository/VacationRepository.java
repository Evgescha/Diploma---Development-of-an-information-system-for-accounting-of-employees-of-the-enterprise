package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Vacation;
import com.hescha.employeeaccounting.model.VacationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByType(String type);

    List<Vacation> findByTypeContains(String type);

    Vacation findByStartDate(LocalDate startDate);

    Vacation findByEndDate(LocalDate endDate);

    Vacation findByDuration(int duration);

    Vacation findByStatus(VacationStatus status);

    Vacation findByEmployee(Employee employee);
}
