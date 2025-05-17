package com.ace.student_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="enroll_id",length = 11)
    private int enrollid;

    @ManyToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(name = "batch_id",nullable = false)
    private Batch batch;


    @Column(name="join_date",length = 12)
    private String joindate;


    @Column(name="fee",length = 12)
    private int fee;



    public Enrollment(Student student, Batch batch, String joindate, int fee) {
        this.student = student;
        this.batch = batch;
        this.joindate = joindate;
        this.fee = fee;
    }


    }


