package com.ace.student_management.service.impl;

import com.ace.student_management.dto.EnrollmentDTO;
import com.ace.student_management.dto.EnrollmentSaveDTO;
import com.ace.student_management.dto.EnrollmentUpdateDTO;
import com.ace.student_management.entity.Batch;
import com.ace.student_management.entity.Enrollment;
import com.ace.student_management.entity.Student;
import com.ace.student_management.exception.NotFoundException;
import com.ace.student_management.repository.BatchRepo;
import com.ace.student_management.repository.EnrollmentRepo;
import com.ace.student_management.repository.StudentRepo;
import com.ace.student_management.service.EnrollmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    @Transactional
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {

        if (!studentRepo.existsById(enrollmentSaveDTO.getStudentid())) {
            throw new NotFoundException("Student not found with ID: " + enrollmentSaveDTO.getStudentid());
        }


        if (!batchRepo.existsById(enrollmentSaveDTO.getBatchid())) {
            throw new NotFoundException("Batch not found with ID: " + enrollmentSaveDTO.getBatchid());
        }


        Enrollment enrollment = new Enrollment(
                studentRepo.getReferenceById(enrollmentSaveDTO.getStudentid()),
                batchRepo.getReferenceById(enrollmentSaveDTO.getBatchid()),
                enrollmentSaveDTO.getJoindate(),
                enrollmentSaveDTO.getFee()
        );

        // Save enrollment
        enrollmentRepo.save(enrollment);
        return "Enrollment saved successfully for student ID: " + enrollmentSaveDTO.getStudentid();
    }

    @Override
    @Transactional
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
        // Verify enrollment exists
        Enrollment enrollment = enrollmentRepo.findById(enrollmentUpdateDTO.getEnrollid())
                .orElseThrow(() -> new NotFoundException("Enrollment not found"));

        // Verify student exists
        Student student = studentRepo.findById(enrollmentUpdateDTO.getStudentid())
                .orElseThrow(() -> new NotFoundException("Student not found"));

        // Verify batch exists
        Batch batch = batchRepo.findById(enrollmentUpdateDTO.getBatchid())
                .orElseThrow(() -> new NotFoundException("Batch not found"));

        // Update enrollment
        enrollment.setStudent(student);
        enrollment.setBatch(batch);
        enrollment.setJoindate(enrollmentUpdateDTO.getJoindate());
        enrollment.setFee(enrollmentUpdateDTO.getFee());

        enrollmentRepo.save(enrollment);
        return "Enrollment updated successfully";
    }

    @Override
    @Transactional
    public boolean deleteEnrollment(int id) {
        if (enrollmentRepo.existsById(id)) {
            enrollmentRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<EnrollmentDTO> getAllEnrollments() {
        List<Enrollment> getEnrollments = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();
        for(Enrollment enrollment:getEnrollments)
        {
            EnrollmentDTO enrollmentDTO = new EnrollmentDTO(
                    enrollment.getEnrollid(),
                    enrollment.getStudent(),
                    enrollment.getBatch(),
                    enrollment.getJoindate(),
                    enrollment.getFee()
            );
            enrollmentDTOList.add(enrollmentDTO);
        }
        return enrollmentDTOList;
    }
}
