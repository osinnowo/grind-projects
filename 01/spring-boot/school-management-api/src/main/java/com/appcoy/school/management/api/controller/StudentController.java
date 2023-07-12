package com.appcoy.school.management.api.controller;

import com.appcoy.school.management.api.app.BaseResponse;
import com.appcoy.school.management.api.configuration.AppConfiguration;
import com.appcoy.school.management.api.configuration.bean.Bag;
import com.appcoy.school.management.api.dto.StudentDto;
import com.appcoy.school.management.api.exception.NotFoundException;
import com.appcoy.school.management.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final AppConfiguration configuration;

    @GetMapping
    public Mono<ResponseEntity<BaseResponse<List<StudentDto>>>> getStudents() {
        return studentService
                .getStudents()
                .collectList()
                .map(BaseResponse::okResponse);
    }

    @GetMapping("/exception")
    public Mono<ResponseEntity<BaseResponse<?>>> throwException() throws Exception {
        throw new NotFoundException("Cannot find students");
    }

    @GetMapping("/threshold")
    public Mono<ResponseEntity<BaseResponse<Integer>>> getThreshold() {
        return Mono.just(BaseResponse.okResponse(configuration.getThresholdCount()));
    }

    @GetMapping("/bag")
    public Mono<ResponseEntity<BaseResponse<Bag>>> getBeanBag() {
        return Mono.just(BaseResponse.okResponse(configuration.getBeanBag()));
    }
}
