package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Role;
import com.hescha.employeeaccounting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByUsernameIgnoreCase(String username);

    List<User> findByUsernameContains(String username);

    List<User> findByPassword(String password);

    List<User> findByPasswordContains(String password);

    User findByEmployee(Employee employee);

    User findByUserRole(Role userRole);
}
