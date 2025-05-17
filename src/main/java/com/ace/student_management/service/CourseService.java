package com.ace.student_management.service;

import com.ace.student_management.dto.CourseDTO;
import com.ace.student_management.dto.CourseSaveDTO;
import com.ace.student_management.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourse();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    Boolean deleteCourse(int id);
}
