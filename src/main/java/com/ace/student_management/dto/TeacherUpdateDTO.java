package com.ace.student_management.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherUpdateDTO {
    private int teacherid;

    private String teachername;

    private String address;

    private String phone;
}
