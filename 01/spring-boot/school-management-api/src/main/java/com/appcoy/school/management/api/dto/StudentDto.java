package com.appcoy.school.management.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentDto {
    private Long id;
    private String name;
    private Integer age;
}
