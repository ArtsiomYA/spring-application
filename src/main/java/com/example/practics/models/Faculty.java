package com.example.practics.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "faculty_name" ,columnDefinition = "varchar(100)")
    private String facultyName;
    @Column(name = "admission_plan" ,columnDefinition = "varchar(100)")
    private String admissionPlan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(facultyName, faculty.facultyName) && Objects.equals(admissionPlan, faculty.admissionPlan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyName, admissionPlan);
    }
}
