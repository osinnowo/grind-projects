package com.appcoy.school.management.api.app;

import com.appcoy.school.management.api.model.Student;
import com.appcoy.school.management.api.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppDelegate implements CommandLineRunner {
    private final StudentRepository repository;
    @Override
    public void run(String... args) throws Exception {
        seedStudentRecord();
    }

    private void seedStudentRecord() {
        List<Student> list = List.of(
                new Student("Cole E. Smith", 32),
                new Student("Frankein MS. Judith", 57),
                new Student("Eric Moore Williams", 39),
                new Student("Struder K. Kawethin", 29)
        );
        repository.saveAllAndFlush(list);
    }
}
