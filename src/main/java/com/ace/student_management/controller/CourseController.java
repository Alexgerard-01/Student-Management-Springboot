package com.ace.student_management.controller;


import com.ace.student_management.dto.*;
import com.ace.student_management.service.CourseService;
import com.ace.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO){
        String coursename=courseService.addCourse(courseSaveDTO);
        return coursename;

    }

    @GetMapping("/getAllCourse")
    public List<CourseDTO> getAllStudents(){
        List<CourseDTO> allCourse=courseService.getAllCourse();

        return allCourse;
    }

    @PutMapping(path = "/update")
    public String updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO){
        String coursename=courseService.updateCourse(courseUpdateDTO);
        return coursename;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteCourse(@PathVariable(value = "id")int id)
    {
        Boolean deleteCourse=courseService.deleteCourse(id);
        return "deleted";

    }
}
