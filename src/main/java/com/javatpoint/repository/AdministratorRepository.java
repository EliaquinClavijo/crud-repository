package com.javatpoint.repository;

import com.javatpoint.model.administrators.Administrator;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

    @Query(value = "SELECT administrator from Administrator administrator where administrator._id = :uID")
    Administrator findByUId(@Param("uID") String uID);

    @Transactional
    @Modifying
    @Query(value = "DELETE  from Administrator administrator where administrator._id = :uID")
    void deleteByUId(@Param("uID") String uID);
}
