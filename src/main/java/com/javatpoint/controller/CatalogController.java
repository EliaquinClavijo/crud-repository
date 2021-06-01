package com.javatpoint.controller;

import com.javatpoint.model.catalog.Catalog;
import com.javatpoint.model.catalog.ResponseCatalog;
import com.javatpoint.model.catalog.ResponseCatalogList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatalogController {

    @Autowired
    CatalogService CatalogService;

    @CrossOrigin
    @GetMapping("/catalogs")
    private ResponseCatalogList getAllCatalogs() {
        return CatalogService.getAllCatalogs();
    }

    @CrossOrigin
    @GetMapping("/catalog")
    private ResponseCatalog getCatalog(@RequestParam("id") String catalogId) {
        return CatalogService.getCatalogById(catalogId);
    }

    @CrossOrigin
    @GetMapping("/delete-catalog")
    private ResponseStatus deleteCompany(@RequestParam("id") String catalogId) {
        return CatalogService.delete(catalogId);
    }

    @CrossOrigin
    @PostMapping("/catalog")
    private ResponseStatus saveCompany(@RequestBody Catalog catalog) {
        return CatalogService.saveOrUpdate(catalog);
    }

    @CrossOrigin
    @PostMapping("/catalog-update")
    private ResponseStatus update(@RequestBody Catalog catalog) {
        return CatalogService.saveOrUpdate(catalog);
    }
}
