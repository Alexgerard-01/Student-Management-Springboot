package com.ace.student_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseUpdateDTO {
    private int courseid;

    private String coursename;

    private String syllabus;

    private String duration;
}
