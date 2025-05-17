package com.ace.student_management.service;

import com.ace.student_management.dto.BatchDTO;
import com.ace.student_management.dto.BatchSaveDTO;
import com.ace.student_management.dto.BatchUpdateDTO;


import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);


    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTO);

    boolean deleteBatch(int id);
}
