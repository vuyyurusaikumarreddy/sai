package com.example.sai.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("companies")
@Data
public class Company {
    
    @Id
    private String id;

    private String company;

    @DBRef
    private List<Recruiter> recruiters; 

    @DBRef
    private List<Job> jobs;


}
