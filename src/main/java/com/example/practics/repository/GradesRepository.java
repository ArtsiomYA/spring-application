package com.example.practics.repository;

import com.example.practics.models.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradesRepository extends JpaRepository<Grades, Long> {

    @Query(value = "SELECT * FROM grades WHERE id_users = ?1", nativeQuery = true)
    List<Grades> findGradesByUsers(Long userId);
}
