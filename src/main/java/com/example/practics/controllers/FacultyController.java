package com.example.practics.controllers;

import com.example.practics.dto.FacultyDto;
import com.example.practics.models.Faculty;
import com.example.practics.repository.FacultyRepository;
import com.example.practics.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyRepository facultyRepository;
    private final FacultyService facultyService;

    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable("id") Faculty faculty) {
        return faculty;
    }

    @PostMapping()
    public Faculty createFaculty(@Valid @RequestBody FacultyDto faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping("{id}")
    public Faculty updateFaculty(@PathVariable("id") Faculty facultyFromDB, @Valid @RequestBody FacultyDto facultyDto) {
        return facultyService.updateFaculty(facultyFromDB, facultyDto);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable("id") Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}
