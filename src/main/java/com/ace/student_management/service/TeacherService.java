package com.ace.student_management.service;

import com.ace.student_management.dto.TeacherDTO;
import com.ace.student_management.dto.TeacherSaveDTO;
import com.ace.student_management.dto.TeacherUpdateDTO;
import com.ace.student_management.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TeacherService {



    String addTeacher(TeacherSaveDTO teacherSaveDTO);



    List<TeacherDTO> getAllTeachers();

    
    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    Boolean deleteTeacher(int id);
}
