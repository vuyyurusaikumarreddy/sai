package com.example.sai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sai.models.Job;

public interface JobsRepository extends MongoRepository<Job, String>{


    
}
