package com.hescha.employeeaccounting.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends AbstractEntity {
    private String name;
    private String description;
    @Override
    public String toString() {
        return name;
    }
}
