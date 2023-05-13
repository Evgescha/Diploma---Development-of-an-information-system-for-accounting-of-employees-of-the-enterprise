package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByTitle(String title);

    List<Training> findByTitleContains(String title);

    List<Training> findByDescription(String description);

    List<Training> findByDescriptionContains(String description);

    Training findByStartDate(LocalDate startDate);

    Training findByEndDate(LocalDate endDate);

    List<Training> findByResult(String result);

    List<Training> findByResultContains(String result);
}
