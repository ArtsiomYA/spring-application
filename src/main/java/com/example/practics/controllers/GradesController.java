package com.example.practics.controllers;

import com.example.practics.dto.GradeDto;
import com.example.practics.models.Grades;
import com.example.practics.repository.GradesRepository;
import com.example.practics.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("grades")
public class GradesController {
    private final GradeService gradeService;
    private final GradesRepository gradesRepository;

    @GetMapping
    public List<Grades> getGrades() {
        return gradesRepository.findAll();
    }

    @GetMapping("{id}")
    public Grades getGrade(@PathVariable("id") Grades grade) {
        return grade;
    }

    @PostMapping
    public Grades createGrade(@Valid @RequestBody GradeDto grade) {
        return gradeService.createGrade(grade);
    }

    @PutMapping("{id}")
    public Grades updateGrade(@PathVariable("id") Grades gradeFromDB, @Valid @RequestBody GradeDto gradeDto) {
        return gradeService.updateGrade(gradeFromDB, gradeDto);
    }

    @DeleteMapping("{id}")
    public void deleteGrade(@PathVariable("id") Grades grade) {
        gradesRepository.delete(grade);
    }
}



