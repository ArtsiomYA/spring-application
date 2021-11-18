package com.example.practics.service;

import com.example.practics.dto.FacultyDto;
import com.example.practics.models.Faculty;
import com.example.practics.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public Faculty createFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyDto.getFacultyName());
        faculty.setAdmissionPlan(facultyDto.getAdmissionPlan());
        return facultyRepository.save(faculty);
    }
}
