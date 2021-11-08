package com.example.practics.controllers;

import com.example.practics.models.Grades;
import com.example.practics.repository.GradesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("grades")
public class GradesController {
    private final GradesRepository gradesRepository;

    @Autowired
    public GradesController(GradesRepository gradesRepository) {
        this.gradesRepository = gradesRepository;
    }

    @GetMapping
    public List<Grades> getGrades() {
        return gradesRepository.findAll();
    }

    @GetMapping("{id}")
    public Grades getGrade(@PathVariable("id") Grades grade) {
        return grade;
    }

    @PostMapping
    public Grades createGrade(@RequestBody Grades grade) {
        return gradesRepository.save(grade);
    }

    @PutMapping("{id}")
    public Grades updateGrade(@PathVariable("id") Grades gradeFromDB, @RequestBody Grades grade) {
        BeanUtils.copyProperties(grade, gradeFromDB, "id");
        return gradesRepository.save(gradeFromDB);
    }

    @DeleteMapping("{id}")
    public void deleteGrade(@PathVariable("id") Grades grade) {
        gradesRepository.delete(grade);
    }
}



