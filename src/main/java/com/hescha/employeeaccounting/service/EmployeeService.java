package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.*;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService extends CrudService<Employee> {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Employee> findByFirstName(String firstName) {
        return repository.findByFirstName(firstName);
    }

    public List<Employee> findByFirstNameContains(String firstName) {
        return repository.findByFirstNameContains(firstName);
    }

    public List<Employee> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public List<Employee> findByLastNameContains(String lastName) {
        return repository.findByLastNameContains(lastName);
    }

    public List<Employee> findByMiddleName(String middleName) {
        return repository.findByMiddleName(middleName);
    }

    public List<Employee> findByMiddleNameContains(String middleName) {
        return repository.findByMiddleNameContains(middleName);
    }

    public Employee findByBirthDate(LocalDate birthDate) {
        return repository.findByBirthDate(birthDate);
    }

    public List<Employee> findByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumber(phoneNumber);
    }

    public List<Employee> findByPhoneNumberContains(String phoneNumber) {
        return repository.findByPhoneNumberContains(phoneNumber);
    }

    public List<Employee> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Employee> findByEmailContains(String email) {
        return repository.findByEmailContains(email);
    }

    public Employee findByPosition(Position position) {
        return repository.findByPosition(position);
    }

    public Employee findByDepartment(Department department) {
        return repository.findByDepartment(department);
    }

    public Set<Employee> findByVacationsContains(Vacation vacations) {
        return repository.findByVacationsContains(vacations);
    }

    public Set<Employee> findBySickLeavesContains(SickLeave sickLeaves) {
        return repository.findBySickLeavesContains(sickLeaves);
    }

    public Set<Employee> findByTrainingsContains(Training trainings) {
        return repository.findByTrainingsContains(trainings);
    }

    public Employee findByUser(User user) {
        return repository.findByUser(user);
    }


    public Employee update(Long id, Employee entity) {
        Employee read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity Employee not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(Employee entity, Employee read) {
        read.setFirstName(entity.getFirstName());
        read.setLastName(entity.getLastName());
        read.setMiddleName(entity.getMiddleName());
        read.setBirthDate(entity.getBirthDate());
        read.setPhoneNumber(entity.getPhoneNumber());
        read.setEmail(entity.getEmail());
        read.setPosition(entity.getPosition());
        read.setDepartment(entity.getDepartment());
    }
}
