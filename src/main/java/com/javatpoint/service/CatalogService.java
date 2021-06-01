package com.javatpoint.service;

import com.javatpoint.model.catalog.Catalog;
import com.javatpoint.model.catalog.ResponseCatalog;
import com.javatpoint.model.catalog.ResponseCatalogList;
import com.javatpoint.model.company.ResponseStatus;
import com.javatpoint.repository.CatalogRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;

    public ResponseCatalogList getAllCatalogs() {
        List<Catalog> catalog = new ArrayList<Catalog>();
        catalogRepository.findAll().forEach(item -> catalog.add(item));
        ResponseCatalogList response = new ResponseCatalogList(true, catalog, catalog.size(), 1, 5);
        return response;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public ResponseCatalog getCatalogById(String id) {
        return new ResponseCatalog(true, catalogRepository.findByUId(id));
    }

    //saving a specific record by using the method save() of CrudRepository
    public ResponseStatus saveOrUpdate(Catalog catalog) {
        if (catalog.get_id() == null) {
            String sha256hex = DigestUtils.sha256Hex(LocalDate.now().toString() + catalog);
            catalog.set_id(sha256hex.substring(0, 24));
            catalog.setStatus(true);
        }
        catalog.setCreated_at(Instant.now().toEpochMilli());
        catalogRepository.save(catalog);
        return new ResponseStatus(true);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public ResponseStatus delete(String id) {
        catalogRepository.deleteByUId(id);
        return new ResponseStatus(true);
    }
}
