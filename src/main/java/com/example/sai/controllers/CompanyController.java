package com.example.sai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sai.models.Company;
import com.example.sai.models.Job;
import com.example.sai.models.Recruiter;
import com.example.sai.services.CompanyService;
import com.example.sai.services.JobsService;
import com.example.sai.services.RecruitersService;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    RecruitersService recruitersService;

    @Autowired
    JobsService jobsService;

    @PostMapping("/insertCompany")
    public ResponseEntity<String> insertCompany(@RequestBody Company company) {
        Company insertedRecord = new Company();

        try {
            insertedRecord = companyService.insertCompany(company);
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body("Error inserting company");
        }

        List<Recruiter> recruiters = insertedRecord.getRecruiters();
        List<Job> jobs = insertedRecord.getJobs();

        if(recruiters != null && !recruiters.isEmpty()) {
            for(Recruiter recruiter : recruiters) {

                try {
                    recruitersService.insertRecruiters(recruiter);
                } catch (Exception e) {
                    return ResponseEntity.status(500).body("Error inserting recruiters");
                }
                
            }
        }

        if(jobs != null && !jobs.isEmpty()) {
            for(Job job : jobs) {

                try {
                    jobsService.insertJobs(job);
                } catch (Exception e) {
                    return ResponseEntity.status(500).body("Error inserting jobs");
                }

            }
        }

        return ResponseEntity.status(200).body("Company inserted successfully");
        
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<Job>> getAllJobs(@RequestParam("name") String name) {
        // return companyService.getAllJobs(name);
        return ResponseEntity.status(200).body(companyService.getAllJobs(name));
    }
}
