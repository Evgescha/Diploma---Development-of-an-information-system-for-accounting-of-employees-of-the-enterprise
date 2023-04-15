package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameContains(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByLastNameContains(String lastName);

    List<Employee> findByMiddleName(String middleName);

    List<Employee> findByMiddleNameContains(String middleName);

    Employee findByBirthDate(LocalDate birthDate);

    List<Employee> findByPhoneNumber(String phoneNumber);

    List<Employee> findByPhoneNumberContains(String phoneNumber);

    List<Employee> findByEmail(String email);

    List<Employee> findByEmailContains(String email);

    Employee findByPosition(Position position);

    Employee findByDepartment(Department department);

    Set<Employee> findByVacationsContains(Vacation vacations);

    Set<Employee> findBySickLeavesContains(SickLeave sickLeaves);

    Set<Employee> findByTrainingsContains(Training trainings);

    Employee findByUser(User user);
}
