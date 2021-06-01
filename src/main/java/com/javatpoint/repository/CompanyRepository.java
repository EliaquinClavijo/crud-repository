package com.javatpoint.repository;

import com.javatpoint.model.company.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query(value = "SELECT company from Company company where company._id = :uID")
    Company findByUId(@Param("uID") String uID);

    @Transactional
    @Modifying
    @Query(value = "DELETE  from Company company where company._id = :uID")
    void deleteByUId(@Param("uID") String uID);
}
