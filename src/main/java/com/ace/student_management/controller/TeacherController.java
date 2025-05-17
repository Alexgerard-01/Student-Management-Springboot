package com.ace.student_management.controller;

import com.ace.student_management.dto.*;

import com.ace.student_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "/save")
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO){
        String teachername=teacherService.addTeacher(teacherSaveDTO);
        return teachername;

    }

    @GetMapping("/getAllTeacher")
    public List<TeacherDTO> getAllTeachers(){
        List<TeacherDTO> allTeacher=teacherService.getAllTeachers();

        return allTeacher;
    }

    @PutMapping(path = "/update")
    public String updateStudent(@RequestBody TeacherUpdateDTO teacherUpdateDTO){
        String teachername=teacherService.updateTeacher(teacherUpdateDTO);
        return teachername;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteTeacher(@PathVariable(value = "id")int id)
    {
        Boolean deleteTeacher=teacherService.deleteTeacher(id);
        return "deleted";

    }
}
