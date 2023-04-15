package com.hescha.employeeaccounting.repository;

import com.hescha.employeeaccounting.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);

    List<Role> findByNameContains(String name);
}
