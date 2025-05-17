package com.ace.student_management.dto;


import com.ace.student_management.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {
    private int batchid;

    private String batchname;

    private Course course;

    private String startdate;
}
