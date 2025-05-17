package com.ace.student_management.service;

import com.ace.student_management.dto.EnrollmentDTO;
import com.ace.student_management.dto.EnrollmentSaveDTO;
import com.ace.student_management.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);

    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    boolean deleteEnrollment(int id);

    List<EnrollmentDTO> getAllEnrollments();
}
