package com.ace.student_management.repository;

import com.ace.student_management.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,Integer> {

}
