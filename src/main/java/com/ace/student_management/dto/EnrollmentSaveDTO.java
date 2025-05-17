package com.ace.student_management.dto;

import com.ace.student_management.entity.Batch;
import com.ace.student_management.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentSaveDTO {

    private int studentid;
    private int batchid;
    private String joindate;
    private int fee;
}
