package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.SickLeave;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SickLeaveService extends CrudService<SickLeave> {

    private final SickLeaveRepository repository;

    public SickLeaveService(SickLeaveRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public SickLeave findByStartDate(LocalDate startDate) {
        return repository.findByStartDate(startDate);
    }

    public SickLeave findByDuration(int duration) {
        return repository.findByDuration(duration);
    }

    public SickLeave findByEmployee(Employee employee) {
        return repository.findByEmployee(employee);
    }


    public SickLeave update(Long id, SickLeave entity) {
        SickLeave read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity SickLeave not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(SickLeave entity, SickLeave read) {
        read.setStartDate(entity.getStartDate());
        read.setDuration(entity.getDuration());
        read.setEmployee(entity.getEmployee());
    }
}
