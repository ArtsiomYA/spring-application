package com.example.practics.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@ToString
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Max(100)
    @Column(name = "subject_first")
    private Integer subjectFirst;

    @Max(100)
    @Column(name = "subject_second")
    private Integer subjectSecond;

    @Max(100)
    @Column(name = "subject_third")
    private Integer subjectThird;

    @Max(100)
    @Column(name = "certificate_score")
    private Integer certificateScore;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_users")
    private Users users;

    @Column(columnDefinition = "boolean default false")
    private Boolean approve;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "id_faculty")
    private Faculty faculty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grades grades = (Grades) o;
        return Objects.equals(id, grades.id) && Objects.equals(subjectFirst, grades.subjectFirst) && Objects.equals(subjectSecond, grades.subjectSecond) && Objects.equals(subjectThird, grades.subjectThird) && Objects.equals(certificateScore, grades.certificateScore) && Objects.equals(users, grades.users) && Objects.equals(approve, grades.approve) && Objects.equals(faculty, grades.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectFirst, subjectSecond, subjectThird, certificateScore, users, approve, faculty);
    }
}
