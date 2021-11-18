package com.example.practics.service;

import com.example.practics.dto.FacultyDto;
import com.example.practics.models.Faculty;
import com.example.practics.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public Faculty createFaculty(FacultyDto facultyDto) {
        List<Faculty> listFaculty = facultyRepository.findAllByFacultyName(facultyDto.getFacultyName());
        if (!listFaculty.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Faculty faculty = new Faculty();
        faculty.setFacultyName(facultyDto.getFacultyName());
        faculty.setAdmissionPlan(facultyDto.getAdmissionPlan());
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty facultyFromDB, FacultyDto facultyDto) {
        facultyFromDB.setAdmissionPlan(facultyDto.getAdmissionPlan());
        facultyFromDB.setFacultyName(facultyDto.getFacultyName());
        return facultyRepository.save(facultyFromDB);
    }
}
