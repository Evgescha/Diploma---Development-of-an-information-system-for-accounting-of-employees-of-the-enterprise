package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MyUser")
public class User extends AbstractEntity {
    @Column(unique = true)
    private String username;
    private String password;

    @OneToOne
    private Employee employee;

    @ManyToOne
    private Role userRole;
}
