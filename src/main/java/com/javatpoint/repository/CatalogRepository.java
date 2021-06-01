package com.javatpoint.repository;

import com.javatpoint.model.catalog.Catalog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

    @Query(value = "SELECT catalog from Catalog catalog where catalog._id = :uID")
    Catalog findByUId(@Param("uID") String uID);

    @Transactional
    @Modifying
    @Query(value = "DELETE  from Catalog catalog where catalog._id = :uID")
    void deleteByUId(@Param("uID") String uID);
}
