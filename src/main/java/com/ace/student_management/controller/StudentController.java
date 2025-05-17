package com.ace.student_management.controller;


import com.ace.student_management.dto.StudentDTO;
import com.ace.student_management.dto.StudentSaveDTO;
import com.ace.student_management.dto.StudentUpdateDTO;
import com.ace.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO){
        String stname=studentService.addStudent(studentSaveDTO);
        return stname;

    }

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){
        List<StudentDTO> allStudent=studentService.getAllStudents();

        return allStudent;
    }

    @PutMapping(path = "/update")
    public String updateStudent(@RequestBody StudentUpdateDTO studentUpdateDTO){
        String stname=studentService.updateStudent(studentUpdateDTO);
        return stname;

    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id")int id)
    {
        Boolean deleteStudent=studentService.deleteStudent(id);
        return "deleted";

    }



}
