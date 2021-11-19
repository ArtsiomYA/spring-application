package com.example.practics.service;

import com.example.practics.dto.GradeDto;
import com.example.practics.exceptions.BadRequestException;
import com.example.practics.models.Grades;
import com.example.practics.repository.FacultyRepository;
import com.example.practics.repository.GradesRepository;
import com.example.practics.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradesRepository gradesRepository;
    private final FacultyRepository facultyRepository;
    private final UsersRepository usersRepository;

    public Grades createGrade(GradeDto gradeDto) {
        List<Grades> grades = gradesRepository.findGradesByUsersId(gradeDto.getUserId());
        if (!grades.isEmpty()) {
            throw new BadRequestException("This user already has grade");
        }
        Grades grade = new Grades();
        grade.setSubjectFirst(gradeDto.getSubjectFirst());
        grade.setSubjectSecond(gradeDto.getSubjectSecond());
        grade.setSubjectThird(gradeDto.getSubjectThird());
        grade.setCertificateScore(gradeDto.getCertificateScore());
        grade.setFaculty(facultyRepository.findFacultyById(gradeDto.getFacultyId()));
        grade.setUsers(usersRepository.findUsersById(gradeDto.getUserId()));
        return gradesRepository.save(grade);
    }

    public Grades updateGrade(Grades gradeFromDB, GradeDto gradeDto) {
        gradeFromDB.setSubjectFirst(gradeDto.getSubjectFirst());
        gradeFromDB.setSubjectSecond(gradeDto.getSubjectSecond());
        gradeFromDB.setSubjectThird(gradeDto.getSubjectThird());
        gradeFromDB.setCertificateScore(gradeDto.getCertificateScore());
        gradeFromDB.setUsers(usersRepository.findUsersById(gradeDto.getUserId()));
        gradeFromDB.setFaculty(facultyRepository.findFacultyById(gradeDto.getFacultyId()));
        return gradesRepository.save(gradeFromDB);
    }
}
