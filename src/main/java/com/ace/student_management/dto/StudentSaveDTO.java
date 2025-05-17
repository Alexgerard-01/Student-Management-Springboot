package com.ace.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentSaveDTO {

    private String studentname;

    private String address;

    private String phone;
}
