package com.javatpoint.service;

import com.javatpoint.model.administrators.Administrator;
import com.javatpoint.model.administrators.ResponseAdministrator;
import com.javatpoint.model.administrators.ResponseAdministratorList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.repository.AdministratorRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    public ResponseAdministratorList getAllAdministrators() {
        List<Administrator> administrators = new ArrayList<Administrator>();
        administratorRepository.findAll().forEach(administrator -> administrators.add(administrator));
        ResponseAdministratorList response = new ResponseAdministratorList(true, administrators, administrators.size(), 1, 5);
        return response;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public ResponseAdministrator getAdministratorById(String id) {
        return new ResponseAdministrator(true, administratorRepository.findByUId(id));
    }

    //saving a specific record by using the method save() of CrudRepository
    public ResponseStatus saveOrUpdate(Administrator administrator) {
        if (administrator.get_id() == null) {
            String sha256hex = DigestUtils.sha256Hex(LocalDate.now().toString() + administrator);
            administrator.set_id(sha256hex.substring(0, 24));
            administrator.setStatus(true);
        }
        administrator.setCreated_at(Instant.now().toEpochMilli());
        administratorRepository.save(administrator);
        return new ResponseStatus(true);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public ResponseStatus delete(String id) {
        administratorRepository.deleteByUId(id);
        return new ResponseStatus(true);
    }
}
