package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Position;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PositionService extends CrudService<Position> {

    private final PositionRepository repository;

    public PositionService(PositionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Position> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Position> findByTitleContains(String title) {
        return repository.findByTitleContains(title);
    }

    public List<Position> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public List<Position> findByDescriptionContains(String description) {
        return repository.findByDescriptionContains(description);
    }

    public Set<Position> findByEmployeesContains(Employee employees) {
        return repository.findByEmployeesContains(employees);
    }


    public Position update(Long id, Position entity) {
        Position read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity Position not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(Position entity, Position read) {
        read.setTitle(entity.getTitle());
        read.setDescription(entity.getDescription());
    }
}
