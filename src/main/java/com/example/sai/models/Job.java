package com.example.sai.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("job")
public class Job {

    public enum STATUS {
        APPLIED, PROCESSING, REJECTED
    }
    
    @Id
    private String id;

    private String title;

    private String portal;

    private String url;

    private STATUS status;

    private List<String> location;
    
    private String company;

}
