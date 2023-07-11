package com.appcoy.school.management.api.model;

import com.appcoy.school.management.api.app.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "students")
@Data
public class Student extends BaseEntity<Student> {
    public String name;
}
