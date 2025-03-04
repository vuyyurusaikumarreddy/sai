package com.example.sai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sai.models.Recruiter;
import com.example.sai.repositories.RecruitersRepository;

@Service
public class RecruitersService {
    
    @Autowired
    RecruitersRepository recruitersRepository;


    public Recruiter insertRecruiters(Recruiter recruiter) {
        return recruitersRepository.save(recruiter);
    }

}
