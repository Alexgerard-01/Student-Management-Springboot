package com.ace.student_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", length = 11)
    private int studentid;

    @Column(name = "student_name", length = 45)
    private String studentname;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;

    // ✅ Custom constructor for save operations (excluding studentid)
    public Student(String studentname, String address, String phone) {
        this.studentname = studentname;
        this.address = address;
        this.phone = phone;
    }
}
