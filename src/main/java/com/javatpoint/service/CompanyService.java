package com.javatpoint.service;

import com.javatpoint.model.company.Company;
import com.javatpoint.model.company.ResponseCompany;
import com.javatpoint.model.company.ResponseCompanyList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.repository.CompanyRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public ResponseCompanyList getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();
        companyRepository.findAll().forEach(company -> companies.add(company));
        ResponseCompanyList response = new ResponseCompanyList(true, companies, companies.size(), 1, 5);
        return response;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public ResponseCompany getCompanyById(String id) {
        return new ResponseCompany(true, companyRepository.findByUId(id));
    }

    //saving a specific record by using the method save() of CrudRepository
    public ResponseStatus saveOrUpdate(Company company) {
        if (company.get_id() == null) {
            String sha256hex = DigestUtils.sha256Hex(LocalDate.now().toString() + company);
            company.set_id(sha256hex.substring(0, 24));
            company.setStatus(true);
        }
        company.setCreated_at(Instant.now().toEpochMilli());
        companyRepository.save(company);
        return new ResponseStatus(true);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public ResponseStatus delete(String id) {
        companyRepository.deleteByUId(id);
        return new ResponseStatus(true);
    }

}
