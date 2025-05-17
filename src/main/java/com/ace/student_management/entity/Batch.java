package com.ace.student_management.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "batch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_id", length = 11)
    private int batchid;

    @Column(name = "batch_name", length = 45)
    private String batchname;

    @Column(name = "start_data", length = 12)
    private String startdate;

    @ManyToOne
    @JoinColumn(name = "course_id",nullable = false)
    private Course course;

    public Batch(String batchname, String startdate, Course course) {
        this.batchname = batchname;
        this.startdate = startdate;
        this.course = course;
    }
}
