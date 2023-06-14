package com.magcdev.school;

import java.util.List;

import org.springframework.stereotype.Service;

import com.magcdev.school.client.StudentClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolReposiroty repository;

    private final StudentClient client;

    public School saveSchool(School student) {
        return repository.save(student);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = repository.findById(schoolId)
        .orElse(
            School.builder()
            .name("School not found")
            .email("Email not found")
            .build()
        );
        var students = client.findAllStudentsBySchool(schoolId); // find all the students from the studen microservice
        return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .students(students)
        .build();
    }
    
}
