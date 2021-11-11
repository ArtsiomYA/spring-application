package com.example.practics.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class GradeDto {

    @Min(1)
    @Max(100)
    private Integer subjectFirst;

    @Min(1)
    @Max(100)
    private Integer subjectSecond;

    @Min(1)
    @Max(100)
    private Integer subjectThird;

    @Min(1)
    @Max(100)
    private Integer certificateScore;
}
