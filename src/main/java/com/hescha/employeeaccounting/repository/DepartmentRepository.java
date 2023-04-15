package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Department;
import com.hescha.employeeaccounting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByName(String name);

    List<Department> findByNameContains(String name);

    List<Department> findByDescription(String description);

    List<Department> findByDescriptionContains(String description);

    Set<Department> findByEmployeesContains(Employee employees);

    Department findByManager(Employee manager);
}
