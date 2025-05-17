package com.ace.student_management.controller;

import com.ace.student_management.dto.EnrollmentDTO;
import com.ace.student_management.dto.EnrollmentSaveDTO;
import com.ace.student_management.dto.EnrollmentUpdateDTO;
import com.ace.student_management.exception.NotFoundException;
import com.ace.student_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO) {
        try {
            String result = enrollmentService.addEnrollment(enrollmentSaveDTO);
            return ResponseEntity.ok(result);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error saving enrollment: " + e.getMessage());
        }
    }


    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments()
    {
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEnrollment(@RequestBody EnrollmentUpdateDTO dto) {
        try {
            String result = enrollmentService.updateEnrollment(dto);
            return ResponseEntity.ok(result);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating enrollment");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable int id) {
        try {
            if (enrollmentService.deleteEnrollment(id)) {
                return ResponseEntity.ok("Enrollment deleted successfully");
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error deleting enrollment: " + e.getMessage());
        }
    }
}
