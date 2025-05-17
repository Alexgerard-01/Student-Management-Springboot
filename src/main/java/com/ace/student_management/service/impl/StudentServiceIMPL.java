package com.ace.student_management.service.impl;

import com.ace.student_management.dto.StudentDTO;
import com.ace.student_management.dto.StudentSaveDTO;
import com.ace.student_management.dto.StudentUpdateDTO;
import com.ace.student_management.entity.Student;
import com.ace.student_management.repository.StudentRepo;
import com.ace.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {


        Student student=new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone()
        );
        studentRepo.save(student);

        return student.getStudentname();
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> getStudents=studentRepo.findAll();
        List<StudentDTO> StudentDTOList=new ArrayList<>();

        for(Student student:getStudents){
            StudentDTO studentDTO =new StudentDTO(
                    student.getStudentid(),
                    student.getStudentname(),
                    student.getAddress(),
                    student.getPhone()
            );
            StudentDTOList.add(studentDTO);
        }


        return StudentDTOList;

    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO)
    {
        if(studentRepo.existsById(studentUpdateDTO.getStudentid())){
            Student student=studentRepo.getById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);
            return student.getStudentname();
        }else{
            System.out.println("Student ID Not Found");
        }



        return "";
    }

    @Override
    public Boolean deleteStudent(int id) {

        if(studentRepo.existsById(id))
        {
            studentRepo.deleteById(id);
        }
        else{
            System.out.println("Student Id Not Found");
        }
        return false ;
    }


}
