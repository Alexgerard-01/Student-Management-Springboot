package com.ace.student_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", length = 11)
    private int teacherid;

    @Column(name = "teacher_name", length = 45)
    private String teachername;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "phone", length = 12)
    private String phone;


    public Teacher(String teachername, String address, String phone) {
        this.teachername = teachername;
        this.address = address;
        this.phone = phone;
    }
}
