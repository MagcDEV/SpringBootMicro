package com.magcdev.school;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolReposiroty repository;

    public School saveSchool(School student) {
        return repository.save(student);
    }

    public List<School> findAllSchools() {
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
        var school = repository.findById(schoolId).orElseThrow(() -> new IllegalArgumentException("School not found"));
        return null;
    }
    
}
