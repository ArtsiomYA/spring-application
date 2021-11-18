package com.example.practics.service;

import com.example.practics.dto.GradeDto;
import com.example.practics.exceptions.BadRequestException;
import com.example.practics.models.Grades;
import com.example.practics.repository.GradesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradesRepository gradesRepository;

    public Grades createGrade(GradeDto gradeDto) {
        List<Grades> grades = gradesRepository.findGradesByUsers(gradeDto.getUser().getId());
        if (!grades.isEmpty()) {
            throw new BadRequestException();
        }
        Grades grade = new Grades();
        grade.setSubjectFirst(gradeDto.getSubjectFirst());
        grade.setSubjectSecond(gradeDto.getSubjectSecond());
        grade.setSubjectThird(gradeDto.getSubjectThird());
        grade.setCertificateScore(gradeDto.getCertificateScore());
        grade.setFaculty(gradeDto.getFaculty());
        grade.setUsers(gradeDto.getUser());
        return gradesRepository.save(grade);
    }

    public Grades updateGrade(Grades gradeFromDB, GradeDto gradeDto) {
        gradeFromDB.setSubjectFirst(gradeDto.getSubjectFirst());
        gradeFromDB.setSubjectSecond(gradeDto.getSubjectSecond());
        gradeFromDB.setSubjectThird(gradeDto.getSubjectThird());
        gradeFromDB.setCertificateScore(gradeDto.getCertificateScore());
        gradeFromDB.setUsers(gradeDto.getUser());
        gradeFromDB.setFaculty(gradeDto.getFaculty());
        return gradesRepository.save(gradeFromDB);
    }
}
