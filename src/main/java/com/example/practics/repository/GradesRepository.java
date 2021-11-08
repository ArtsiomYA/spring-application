package com.example.practics.repository;

import com.example.practics.models.Grades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradesRepository extends JpaRepository<Grades, Long> {
}
