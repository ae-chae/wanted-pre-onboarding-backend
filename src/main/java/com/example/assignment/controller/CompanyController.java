package com.example.assignment.controller;

import com.example.assignment.entity.Company;
import com.example.assignment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("{id}")
    public Company getCompanyById(@PathVariable("id") String id){
        return companyService.getCompanyById(id);
    }

}
