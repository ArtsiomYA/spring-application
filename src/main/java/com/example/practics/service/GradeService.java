package com.example.practics.service;

import com.example.practics.dto.GradeDto;
import com.example.practics.models.Grades;
import com.example.practics.repository.GradesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradesRepository gradesRepository;

    public Grades createGrade(GradeDto gradeDto) {
        var grade = new Grades();
        grade.setSubjectFirst(gradeDto.getSubjectFirst());
        grade.setSubjectSecond(gradeDto.getSubjectSecond());
        grade.setSubjectThird(gradeDto.getSubjectThird());
        grade.setCertificateScore(gradeDto.getCertificateScore());
        grade.setApprove(gradeDto.getApprove());
        grade.setFaculty(gradeDto.getFaculty());
        grade.setUsers(gradeDto.getUser());
        return gradesRepository.save(grade);
    }
}
