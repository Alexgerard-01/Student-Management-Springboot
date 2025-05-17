package com.ace.student_management.controller;


import com.ace.student_management.dto.*;
import com.ace.student_management.service.BatchService;
import com.ace.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/batch")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping(path = "/save")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO){
        String batchname=batchService.addBatch(batchSaveDTO);
        return batchname;
    }

    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatches(){
        {
            List<BatchDTO> allBatches = batchService.getAllBatches();
            return allBatches;
        }
    }

    @PutMapping(path = "/update")
    public String updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO)
    {
        String course = batchService.updateBatch(batchUpdateDTO);
        return course;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteBatch(@PathVariable(value = "id")int id)
    {
        boolean deleteCourse = batchService.deleteBatch(id);
        return "deleted";
    }
}
