package com.example.sai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.sai.models.Company;
import com.example.sai.models.Job;
import com.example.sai.repositories.CompanyRepository;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Company insertCompany(Company company){
        
        return companyRepository.save(company);
        
    }

    public Company findByCompany(String companyName) {
        Company company =  companyRepository.findByCompany(companyName);
        return company;
    }

    public void updateCompany(String name, Job company_job) {

        Query query = new Query(Criteria.where("company").is(name));
        Update update = new Update().push("jobs", /*company_job.getId() + " - " + company_job.getTitle()*/ company_job.getId());
        mongoTemplate.updateFirst(query, update, Company.class);
    }

    public List<Job> getAllJobs(String name) {
        Company company = companyRepository.findByCompany(name);
        return company.getJobs();
    }

    public Company getId(String company) {

        return companyRepository.findByCompany(company);

    }

}
