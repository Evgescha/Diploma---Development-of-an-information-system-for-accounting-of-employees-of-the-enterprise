package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Training;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService extends CrudService<Training> {

    private final TrainingRepository repository;

    public TrainingService(TrainingRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Training> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public List<Training> findByTitleContains(String title) {
        return repository.findByTitleContains(title);
    }

    public List<Training> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    public List<Training> findByDescriptionContains(String description) {
        return repository.findByDescriptionContains(description);
    }

    public Training findByStartDate(LocalDate startDate) {
        return repository.findByStartDate(startDate);
    }

    public Training findByEndDate(LocalDate endDate) {
        return repository.findByEndDate(endDate);
    }

    public List<Training> findByResult(String result) {
        return repository.findByResult(result);
    }

    public List<Training> findByResultContains(String result) {
        return repository.findByResultContains(result);
    }

    public Training findByEmployee(Employee employee) {
        return repository.findByEmployee(employee);
    }


    public Training update(Long id, Training entity) {
        Training read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity Training not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(Training entity, Training read) {
        read.setTitle(entity.getTitle());
        read.setDescription(entity.getDescription());
        read.setStartDate(entity.getStartDate());
        read.setEndDate(entity.getEndDate());
        read.setResult(entity.getResult());
        read.setEmployee(entity.getEmployee());
    }
}
