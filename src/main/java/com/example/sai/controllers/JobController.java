package com.example.sai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sai.models.Job;
import com.example.sai.services.CompanyService;
import com.example.sai.services.JobsService;

@RestController
@RequestMapping("job")
public class JobController {
    
    @Autowired
    JobsService jobsService;

    @Autowired
    CompanyService companyService;

    @PostMapping("/insertJob")
    private ResponseEntity<String> insertJob(@RequestBody Job job) {
        try {
            jobsService.insertJobs(job);
        } catch (Exception e) {
            
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error inserting Job");
        }
        try {
            companyService.updateCompany(job.getCompany(), job);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error adding job to companys");
        }
        
        return ResponseEntity.status(200).body("Job " + job.getId() + " inserted successfully and added to the company " + job.getCompany());

    }

}
