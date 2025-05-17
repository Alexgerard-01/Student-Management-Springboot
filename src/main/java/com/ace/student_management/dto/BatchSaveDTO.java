package com.ace.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchSaveDTO {
    private String batchname;

    private int courseid;

    private String startdate;
}
