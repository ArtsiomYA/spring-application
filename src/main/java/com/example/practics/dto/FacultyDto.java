package com.example.practics.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FacultyDto {

    @NotNull
    private String admissionPlan;
    @NotNull
    private String facultyName;
}
