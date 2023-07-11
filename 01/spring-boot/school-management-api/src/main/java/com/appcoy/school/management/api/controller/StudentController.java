package com.appcoy.school.management.api.controller;

import com.appcoy.school.management.api.app.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @GetMapping
    public Flux<ResponseEntity<BaseResponse<String>>> getStudents() {
        return Flux.just(BaseResponse.okResponse());
    }
}
