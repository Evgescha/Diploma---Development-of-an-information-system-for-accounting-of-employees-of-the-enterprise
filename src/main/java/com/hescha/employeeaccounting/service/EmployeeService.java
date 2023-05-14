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


    public List<Employee> findByPosition(Position position) {
        return repository.findByPosition(position);
    }

    public List<Employee> findByRole(Role role) {
        return repository.findByRole(role);
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
        read.setImage(entity.getImage());
        read.setPosition(entity.getPosition());
        read.setDepartment(entity.getDepartment());
        read.setRole(entity.getRole());
    }
}
