package com.example.sai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sai.models.Job;
import com.example.sai.repositories.JobsRepository;

@Service
public class JobsService {
    
    @Autowired
    JobsRepository jobsRepository;

    public Job insertJobs(Job jobs) {
        return jobsRepository.save(jobs);
    }

}
