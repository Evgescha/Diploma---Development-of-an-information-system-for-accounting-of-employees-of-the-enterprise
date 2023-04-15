package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    List<Position> findByTitle(String title);

    List<Position> findByTitleContains(String title);

    List<Position> findByDescription(String description);

    List<Position> findByDescriptionContains(String description);

    Set<Position> findByEmployeesContains(Employee employees);
}
