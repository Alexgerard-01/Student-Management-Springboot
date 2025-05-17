package com.ace.student_management.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", length = 11)
    private int courseid;

    @Column(name = "course_name", length = 45)
    private String coursename;

    @Column(name = "syllabus", length = 60)
    private String syllabus;

    @Column(name = "duration", length = 12)
    private String duration;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Batch> batches;

    public Course(String coursename, String syllabus, String duration) {
        this.coursename = coursename;
        this.syllabus = syllabus;
        this.duration = duration;
    }
}
