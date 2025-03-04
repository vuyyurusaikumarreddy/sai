package com.example.sai.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sai.models.Company;
import com.example.sai.repositories.CompanyRepository;
import com.example.sai.services.MainService;

@RestController()
@RequestMapping("/main")
public class MainController {
    
    @Autowired
    private MainService companyService;

    @Autowired
    private CompanyRepository company;

    @GetMapping("{company_name}")
    private Company getCompany(@PathVariable String company_name){
        return companyService.getCompanyDetails(company_name);
    }

    @GetMapping("companies")
    private List<Company> getAllCompanies(){
        return company.findAll();
    }
}
