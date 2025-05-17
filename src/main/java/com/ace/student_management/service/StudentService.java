package com.ace.student_management.service;

import com.ace.student_management.dto.StudentDTO;
import com.ace.student_management.dto.StudentSaveDTO;
import com.ace.student_management.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

     List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    Boolean deleteStudent(int id);

}
