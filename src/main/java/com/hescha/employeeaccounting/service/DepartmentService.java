package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Department;
import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DepartmentService extends CrudService<Department> {

    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Department> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Department> findByNameContains(String name) {
        return repository.findByNameContains(name);
    }

    public List<Department> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public List<Department> findByDescriptionContains(String description) {
        return repository.findByDescriptionContains(description);
    }

    public Set<Department> findByEmployeesContains(Employee employees) {
        return repository.findByEmployeesContains(employees);
    }

    public Department findByManager(Employee manager) {
        return repository.findByManager(manager);
    }


    public Department update(Long id, Department entity) {
        Department read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity Department not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(Department entity, Department read) {
        read.setName(entity.getName());
        read.setDescription(entity.getDescription());
        read.setManager(entity.getManager());
    }
}
