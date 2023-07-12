package com.appcoy.school.management.api.mapper;

import com.appcoy.school.management.api.dto.StudentDto;
import com.appcoy.school.management.api.model.Student;

public class StudentMapper {
    public static StudentDto mapFrom(Student student) {
        StudentDto dto = StudentDto
                .builder()
                .id(student.getId())
                .age(student.getAge())
                .name(student.getName())
                .build();
        return dto;
    }
}
