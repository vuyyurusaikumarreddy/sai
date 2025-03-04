package com.example.sai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sai.models.Company;
import com.example.sai.repositories.CompanyRepository;

@Service
public class MainService {

    @Autowired
    CompanyRepository companyRepository;

    public Company getCompanyDetails(String companyName){
        Company companyDetails = companyRepository.findByCompany(companyName);
        return companyDetails;
    }
}
