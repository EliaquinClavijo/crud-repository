package com.javatpoint.controller;

import com.javatpoint.model.administrators.Administrator;
import com.javatpoint.model.administrators.ResponseAdministrator;
import com.javatpoint.model.administrators.ResponseAdministratorList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @CrossOrigin
    @GetMapping("/administrators")
    private ResponseAdministratorList getAllAdministrators() {
        return administratorService.getAllAdministrators();
    }

    @CrossOrigin
    @GetMapping("/administrator")
    private ResponseAdministrator getAdministratorById(@RequestParam("id") String administratorId) {
        return administratorService.getAdministratorById(administratorId);
    }

    @CrossOrigin
    @GetMapping("/delete-administrator")
    private ResponseStatus deleteAdministrator(@RequestParam("id") String administratorId) {
        return administratorService.delete(administratorId);
    }

    @CrossOrigin
    @PostMapping("/administrator")
    private ResponseStatus saveAdministrator(@RequestBody Administrator administrator) {
        return administratorService.saveOrUpdate(administrator);
    }

    @CrossOrigin
    @PostMapping("/administrator-update")
    private ResponseStatus update(@RequestBody Administrator administrator) {
        return administratorService.saveOrUpdate(administrator);
    }
}
