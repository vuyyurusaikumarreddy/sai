package com.example.sai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sai.models.Recruiter;

public interface RecruitersRepository extends MongoRepository<Recruiter, String> {
    
}
