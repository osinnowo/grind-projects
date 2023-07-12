package com.appcoy.school.management.api.service;

import com.appcoy.school.management.api.dto.StudentDto;
import com.appcoy.school.management.api.mapper.StudentMapper;
import com.appcoy.school.management.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    public final StudentRepository repository;

    public Flux<StudentDto> getStudents() {
        return Flux.fromIterable(
                repository
                        .findAll()
                        .stream()
                        .map(StudentMapper::mapFrom)
                        .collect(Collectors.toList())
        );
    }
}
