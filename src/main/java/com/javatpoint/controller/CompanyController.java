package com.javatpoint.controller;

import com.javatpoint.model.company.Company;
import com.javatpoint.model.company.ResponseCompany;
import com.javatpoint.model.company.ResponseCompanyList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @CrossOrigin
    @GetMapping("/companies")
    private ResponseCompanyList getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @CrossOrigin
    @GetMapping("/company")
    private ResponseCompany getCompany(@RequestParam("id") String companyId) {
        return companyService.getCompanyById(companyId);
    }

    @CrossOrigin
    @GetMapping("/delete-company")
    private ResponseStatus deleteCompany(@RequestParam("id") String companyId) {
        return companyService.delete(companyId);
    }

    @CrossOrigin
    @PostMapping("/company")
    private ResponseStatus saveCompany(@RequestBody Company company) {
        return companyService.saveOrUpdate(company);
    }

    @CrossOrigin
    @PostMapping("/company-update")
    private ResponseStatus update(@RequestBody Company company) {
        return companyService.saveOrUpdate(company);
    }
}
