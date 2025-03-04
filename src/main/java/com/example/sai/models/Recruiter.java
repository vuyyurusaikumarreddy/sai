package com.example.sai.models;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("recruiter")
@Data
public class Recruiter {

    public enum CONNECTION_STATUS {
        ACCEPTED, NOT_ACCEPTED
    }
    
    
    @Id
    private UUID id;

    private String name;

    private CONNECTION_STATUS connection;

    @DBRef
    private Job job;

    @DBRef
    private Company companyName;

}
