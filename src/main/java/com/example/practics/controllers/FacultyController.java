package com.example.practics.controllers;

import com.example.practics.models.Faculty;
import com.example.practics.repository.FacultyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @GetMapping("{id}")
    public Faculty getFaculty(@PathVariable("id") Faculty faculty) {
        return faculty;
    }

    @PostMapping()
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @PutMapping("{id}")
    public Faculty updateFaculty(@PathVariable("id") Faculty facultyFromDB, @RequestBody Faculty faculty) {
        BeanUtils.copyProperties(faculty, facultyFromDB, "id");
        return facultyRepository.save(facultyFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable("id") Faculty faculty) {
        facultyRepository.delete(faculty);
    }
}
