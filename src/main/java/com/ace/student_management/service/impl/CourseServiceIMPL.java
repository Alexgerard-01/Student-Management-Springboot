package com.ace.student_management.service.impl;

import com.ace.student_management.dto.CourseDTO;
import com.ace.student_management.dto.CourseSaveDTO;
import com.ace.student_management.dto.CourseUpdateDTO;
import com.ace.student_management.dto.StudentDTO;
import com.ace.student_management.entity.Course;
import com.ace.student_management.entity.Student;
import com.ace.student_management.repository.CourseRepo;
import com.ace.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        Course course=new Course(
                courseSaveDTO.getCoursename(),
                courseSaveDTO.getSyllabus(),
                courseSaveDTO.getDuration()
        );
        courseRepo.save(course);

        return course.getCoursename();


    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<Course> getCourses=courseRepo.findAll();
        List<CourseDTO> CourseDTOList=new ArrayList<>();

        for(Course course:getCourses){
            CourseDTO courseDTO =new CourseDTO(
                    course.getCourseid(),
                    course.getCoursename(),
                    course.getSyllabus(),
                    course.getDuration()
            );
            CourseDTOList.add(courseDTO);
        }


        return CourseDTOList;
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
        if(courseRepo.existsById(courseUpdateDTO.getCourseid())){
            Course course=courseRepo.getById(courseUpdateDTO.getCourseid());
            course.setCoursename(courseUpdateDTO.getCoursename());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            course.setDuration(courseUpdateDTO.getDuration());
            courseRepo.save(course);
            return course.getCoursename();
        }else{
            System.out.println("Course ID Not Found");
        }



        return null;
    }

    @Override
    public Boolean deleteCourse(int id) {
       if(courseRepo.existsById(id)){
           courseRepo.deleteById(id);
       }else{
           System.out.println("Course Id Not Found");
       }
       return false;
    }
}
