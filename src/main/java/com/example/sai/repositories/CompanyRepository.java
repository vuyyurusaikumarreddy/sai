package com.example.sai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.sai.models.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {
    Company findByCompany(String company);
}
