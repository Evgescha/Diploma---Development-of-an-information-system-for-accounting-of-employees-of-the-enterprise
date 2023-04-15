package com.hescha.employeeaccounting.service;

import com.hescha.employeeaccounting.model.Employee;
import com.hescha.employeeaccounting.model.Role;
import com.hescha.employeeaccounting.model.User;
import com.hescha.employeeaccounting.repository.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends CrudService<User>  implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь " + username + " не был найден в базе");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), List.of());
    }

    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public User findByUsernameIgnoreCase(String username) {
        return repository.findByUsernameIgnoreCase(username);
    }

    public List<User> findByUsernameContains(String username) {
        return repository.findByUsernameContains(username);
    }

    public List<User> findByPassword(String password) {
        return repository.findByPassword(password);
    }

    public List<User> findByPasswordContains(String password) {
        return repository.findByPasswordContains(password);
    }

    public User findByEmployee(Employee employee) {
        return repository.findByEmployee(employee);
    }

    public User findByUserRole(Role userRole) {
        return repository.findByUserRole(userRole);
    }


    public User update(Long id, User entity) {
        User read = read(id);
        if (read == null) {
            throw new RuntimeException("Entity User not found");
        }
        updateFields(entity, read);
        return update(read);

    }

    private void updateFields(User entity, User read) {
        read.setUsername(entity.getUsername());
        read.setPassword(entity.getPassword());
        read.setEmployee(entity.getEmployee());
        read.setUserRole(entity.getUserRole());
    }
}
