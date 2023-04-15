package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Vacation;
import com.hescha.employeeaccounting.model.VacationStatus;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VacationService extends CrudService<Vacation> {

    private final VacationRepository repository;

    public VacationService(VacationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Vacation> findByType(String type) {
        return repository.findByType(type);
    }

    public List<Vacation> findByTypeContains(String type) {
        return repository.findByTypeContains(type);
    }

    public Vacation findByStartDate(LocalDate startDate) {
        return repository.findByStartDate(startDate);
    }

    public Vacation findByEndDate(LocalDate endDate) {
        return repository.findByEndDate(endDate);
    }

    public Vacation findByDuration(int duration) {
        return repository.findByDuration(duration);
    }

    public Vacation findByStatus(VacationStatus status) {
        return repository.findByStatus(status);
    }

    public Vacation findByEmployee(Employee employee) {
        return repository.findByEmployee(employee);
    }


    public Vacation update(Long id, Vacation entity) {
        Vacation read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity Vacation not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(Vacation entity, Vacation read) {
        read.setType(entity.getType());
        read.setStartDate(entity.getStartDate());
        read.setEndDate(entity.getEndDate());
        read.setDuration(entity.getDuration());
        read.setStatus(entity.getStatus());
        read.setEmployee(entity.getEmployee());
    }
}
